package example;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

public class WordCountJob {
    public static void main(String[] args) {
        // get environment and read data
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        final String filePath = "file:////Users/ESumitra/tools/flink-1.14.0/README.txt";
        DataStreamSource<String> text = env
                .readTextFile(filePath);

        // transform data
        DataStream<Tuple2<String, Integer>> counts = text
                .flatMap(new Splitter())
                .keyBy(value -> value.f0)
                .sum(1);

        // print or write to sink
        counts.print();

        try {
            env.execute("Window WordCount");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Splitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String sentence, Collector<Tuple2<String, Integer>> out) throws Exception {
            for (String word: sentence.split(" ")) {
                out.collect(new Tuple2<String, Integer>(word, 1));
            }
        }
    }

}


