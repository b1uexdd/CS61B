package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

import static javax.swing.text.html.HTML.Attribute.N;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> NS = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        NS.addLast(1000);
        NS.addLast(2000);
        NS.addLast(4000);
        NS.addLast(8000);
        NS.addLast(16000);
        NS.addLast(32000);
        NS.addLast(64000);
        NS.addLast(1000000);
        // TODO: YOUR CODE HERE
        for(int i=0; i<NS.size(); i++) {
            AList<Integer> primitiveList = new AList<>();
            int x = NS.get(i);
            Stopwatch sw = new Stopwatch();
            int opcount = 0;
            while (primitiveList.size() < x) {
                opcount += 1;
                primitiveList.addLast(1);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(opcount);
        }
        printTimingTable(NS, times, opCounts);
    }
}
