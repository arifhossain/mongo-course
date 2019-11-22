package helloflink;

import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.util.Collector;


public class WordCount {
    public static void main(String[] args) throws Exception {
        System.out.println("ARGS: " + args.length);
        ParameterTool params = ParameterTool.fromArgs(args);

        ExecutionEnvironment environment = ExecutionEnvironment.getExecutionEnvironment();
        environment.getConfig().setGlobalJobParameters(params);

        if (!params.has("input")) {
           //throw new IllegalArgumentException("No input path");
        }
        DataSet<String> source = environment.readTextFile("/Users/arif/workspace/sample.txt");

        DataSet<Tuple2<String, Integer>> count = source
                .flatMap((String value, Collector<Tuple2<String, Integer>> out) -> {
                    String[] tokens = value.toLowerCase().split("\\W+");

                    // emit the pairs
                    for (String token : tokens) {
                        if (token.length() > 0) {
                            out.collect(new Tuple2<>(token, 1));
                        }
                    }
                })
                .returns(TypeInformation.of(new TypeHint<Tuple2<String, Integer>>(){}))
                .groupBy(0)
                .sum(1);

        count.print();

    }
}
