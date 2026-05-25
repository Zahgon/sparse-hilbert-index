package com.github.davidmoten.shi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UncheckedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import org.davidmoten.hilbert.HilbertCurve;
import org.davidmoten.hilbert.Range;
import org.davidmoten.hilbert.Ranges;
import org.davidmoten.hilbert.SmallHilbertCurve;
import org.davidmoten.kool.Stream;
import org.davidmoten.kool.function.BiFunction;
import com.github.davidmoten.bigsorter.Reader;
import com.github.davidmoten.bigsorter.Serializer;
import com.github.davidmoten.bigsorter.Sorter;
import com.github.davidmoten.bigsorter.Writer;
import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.guavamini.annotations.VisibleForTesting;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public final class Index<T> {

    private static final short VERSION = 1;

    private final TreeMap<Integer, Long> indexPositions;

    private final double[] mins;

    private final double[] maxes;

    private final SmallHilbertCurve hc;

    private final long count;

    private final Serializer<? extends T> serializer;

    private final Function<? super T, double[]> pointMapper;

    Index(TreeMap<Integer, Long> indexPositions, double[] mins, double[] maxes, int bits, long count, Serializer<? extends T> serializer, Function<? super T, double[]> pointMapper) {
        this.indexPositions = indexPositions;
        this.mins = mins;
        this.maxes = maxes;
        this.count = count;
        this.serializer = serializer;
        this.pointMapper = pointMapper;
        this.hc = HilbertCurve.small().bits(bits).dimensions(mins.length);
    }

    public Serializer<? extends T> serializer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Function<? super T, double[]> pointMapper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Builder1<T> serializer(Serializer<? extends T> serializer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Builder builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class Builder {

        Builder() {
            // prevent instantiation externally
        }

        public <T> Builder1<T> serializer(Serializer<? extends T> serializer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class Builder1<T> {

        private final Serializer<? extends T> serializer;

        Function<? super T, double[]> pointMapper;

        File input;

        File output;

        int bits;

        int dimensions;

        int numIndexEntriesApproximate = 10000;

        int sortMaxFilesPerMerge = 100;

        int sortMaxItemsPerFile = 100000;

        Builder1(Serializer<? extends T> serializer) {
            this.serializer = serializer;
        }

        public Builder2<T> pointMapper(Function<? super T, double[]> pointMapper) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class Builder2<T> {

        private final Builder1<T> b;

        Builder2(Builder1<T> b) {
            this.b = b;
        }

        public Builder3<T> input(File input) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder3<T> input(String filename) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Index<T> read(DataInputStream in) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Index<T> read(File file) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Index<T> read(URL url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class Builder3<T> {

        private final Builder1<T> b;

        Builder3(Builder1<T> b) {
            this.b = b;
        }

        public Builder4<T> output(File output) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder4<T> output(String output) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class Builder4<T> {

        private final Builder1<T> b;

        Builder4(Builder1<T> b) {
            this.b = b;
        }

        public Builder5<T> bits(int bits) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class Builder5<T> {

        private final Builder1<T> b;

        Builder5(Builder1<T> b) {
            this.b = b;
        }

        public Builder6<T> dimensions(int dimensions) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class Builder6<T> {

        private final Builder1<T> b;

        Builder6(Builder1<T> b) {
            this.b = b;
        }

        /**
         * Sets the <i>approximate</i> number of index entries. The number required will
         * depend on where the chunking falls so can vary by a few from the desired
         * value.
         *
         * @param numIndexEntries approximate number of index entries
         * @return builder
         */
        public Builder6<T> numIndexEntries(int numIndexEntries) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder6<T> sortMaxFilesPerMerge(int sortMaxFilesPerMerge) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Builder6<T> sortMaxItemsPerFile(int sortMaxItemsPerFile) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Index<T> createIndex(String filename) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Index<T> createIndex(File file) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Index<T> createIndex() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @VisibleForTesting
    TreeMap<Integer, Long> indexPositions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Fits the desired ranges to the effective querying ranges according to the
     * known index positions.
     *
     * @param ranges list of ranges in ascending order
     * @return querying ranges based on known index positions
     */
    public List<PositionRange> positionRanges(Iterable<Range> ranges) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @VisibleForTesting
    static List<PositionRange> positionRanges(TreeMap<Integer, Long> indexPositions, Iterable<Range> ranges) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void append(LinkedList<PositionRange> list, PositionRange p) {
        if (list.isEmpty()) {
            list.offer(p);
        } else {
            PositionRange last = list.getLast();
            if (p.floorPosition() <= last.ceilingPosition()) {
                list.pollLast();
                list.offer(last.join(p));
            } else {
                list.offer(p);
            }
        }
    }

    private static <T, R> R value(Entry<T, R> entry) {
        if (entry == null) {
            return null;
        } else {
            return entry.getValue();
        }
    }

    public double[] mins() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double[] maxes() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Returns count of records in file indexed by this.
     *
     * @return count of records in file indexed by this.
     */
    public long count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long[] ordinates(double... d) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SmallHilbertCurve hilbertCurve() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T> Index<T> read(DataInputStream dis, Serializer<? extends T> serializer, Function<? super T, double[]> point) {
        try {
            // read version
            dis.readShort();
            int bits = dis.readInt();
            int dimensions = dis.readInt();
            double[] mins = new double[dimensions];
            double[] maxes = new double[dimensions];
            for (int i = 0; i < dimensions; i++) {
                mins[i] = dis.readDouble();
                maxes[i] = dis.readDouble();
            }
            long count = dis.readLong();
            int numEntries = dis.readInt();
            boolean useLongPositions = dis.readInt() == 1;
            TreeMap<Integer, Long> indexPositions = new TreeMap<Integer, Long>();
            for (int i = 0; i < numEntries; i++) {
                int index = dis.readInt();
                final long pos;
                if (useLongPositions) {
                    pos = dis.readLong();
                } else {
                    pos = (long) dis.readInt();
                }
                indexPositions.put(index, pos);
            }
            return new Index<T>(indexPositions, mins, maxes, bits, count, serializer, point);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public Index<T> write(File idx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Index<T> write(DataOutputStream dos) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static BiFunction<Long, Optional<Long>, InputStream> rafInputStreamFactory(File file) {
        return (first, last) -> {
            RandomAccessFile raf = createRaf(file);
            raf.seek(first);
            return new //
            ClosingInputStream(new //
            LimitingInputStream(new BufferedInputStream(Channels.newInputStream(raf.getChannel())), last.orElse(Long.MAX_VALUE) - first), () -> raf.close());
        };
    }

    @VisibleForTesting
    Flowable<T> search(Bounds queryBounds, File file, PositionRange pr) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @VisibleForTesting
    Flowable<T> search(Bounds queryBounds, BiFunction<Long, Optional<Long>, InputStream> factory, PositionRange pr) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class Counts {

        final long startTime;

        long recordsRead;

        long recordsFound;

        long positionRanges;

        long bytesRead;

        long totalTimeToFirstByte;

        Counts() {
            this.startTime = System.currentTimeMillis();
        }

        synchronized void incrementRecordsRead() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        synchronized void incrementRecordsFoundAndAddTTFBAndAddBytesRead(long ttfb, long bytes) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @VisibleForTesting
    Flowable<WithStats<T>> searchWithStats(Bounds queryBounds, BiFunction<Long, Optional<Long>, InputStream> factory, PositionRange pr, Counts counts) throws IOException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Flowable<T> getValues(BiFunction<Long, Optional<Long>, InputStream> factory, PositionRange pr) {
        return Flowable.defer(() -> {
            InputStream[] in = new InputStream[1];
            final Reader<? extends T> r;
            try {
                Optional<Long> ceiling = pr.ceilingPosition() == Long.MAX_VALUE ? Optional.empty() : Optional.of(pr.ceilingPosition());
                // TODO don't block
                in[0] = factory.apply(pr.floorPosition(), ceiling);
                r = serializer.createReader(in[0]);
            } catch (Throwable t) {
                closeSilently(in[0]);
                return Flowable.error(t);
            }
            return //
            Flowable.<//
            T>//
            generate(emitter -> {
                T t;
                while (true) {
                    t = r.read();
                    if (t == null) {
                        emitter.onComplete();
                        break;
                    } else {
                        emitter.onNext(t);
                        break;
                    }
                    // else keep reading till EOF or next record found within queryBounds
                }
            }).//
            doOnCancel(() -> {
                closeSilently(r);
                closeSilently(in[0]);
            });
        });
    }

    @VisibleForTesting
    static void closeSilently(Closeable c) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int numEntries() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchBuilder search(double[] a, double[] b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SearchBuilder search(Bounds bounds) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public final class SearchBuilder {

        private final Bounds bounds;

        private int maxRanges;

        private int rangesBufferSize;

        private int concurrency = 1;

        SearchBuilder(Bounds bounds) {
            this.bounds = bounds;
        }

        public SearchBuilderWithStats withStats() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilderAdvanced advanced() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilder maxRanges(int maxRanges) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilder rangesBufferSize(int rangeBufferSize) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilder concurrency(int concurrency) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<T> file(File file) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<T> file(String filename) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<T> inputStreamFactory(BiFunction<Long, Optional<Long>, InputStream> inputStreamFactory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Specify an HTTP url to use (server must support Range HTTP header)
         * @param url address
         * @return stream
         */
        public Flowable<T> url(String url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Specify an HTTP url to use (server must support Range HTTP header)
         * @param url address
         * @return stream
         */
        public Flowable<T> url(URL url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public final class SearchBuilderAdvanced {

        private final Index<T>.SearchBuilder b;

        SearchBuilderAdvanced(SearchBuilder b) {
            this.b = b;
        }

        public SearchBuilderWithStatsAdvanced withStats() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilderAdvanced maxRanges(int maxRanges) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilderAdvanced rangesBufferSize(int rangeBufferSize) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<Flowable<T>> file(File file) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<Flowable<T>> file(String filename) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<Flowable<T>> inputStreamFactory(BiFunction<Long, Optional<Long>, InputStream> inputStreamFactory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Specify an HTTP url to use (server must support Range HTTP header)
         * @param url address
         * @return stream of streams
         */
        public Flowable<Flowable<T>> url(String url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Specify an HTTP url to use (server must support Range HTTP header)
         * @param url address
         * @return stream of streams
         */
        public Flowable<Flowable<T>> url(URL url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public final class SearchBuilderWithStats {

        private final Index<T>.SearchBuilder b;

        SearchBuilderWithStats(Index<T>.SearchBuilder b) {
            this.b = b;
        }

        public SearchBuilderWithStats maxRanges(int maxRanges) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilderWithStats rangesBufferSize(int rangeBufferSize) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilderWithStats concurrency(int concurrency) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilderWithStatsAdvanced advanced() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<WithStats<T>> file(File file) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<WithStats<T>> inputStreamFactory(BiFunction<Long, Optional<Long>, InputStream> inputStreamFactory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<WithStats<T>> url(String url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<WithStats<T>> url(URL url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public final class SearchBuilderWithStatsAdvanced {

        private final Index<T>.SearchBuilder b;

        SearchBuilderWithStatsAdvanced(SearchBuilder b) {
            this.b = b;
        }

        public SearchBuilderWithStatsAdvanced maxRanges(int maxRanges) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public SearchBuilderWithStatsAdvanced rangesBufferSize(int rangeBufferSize) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<Flowable<WithStats<T>>> file(File file) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<Flowable<WithStats<T>>> file(String filename) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<Flowable<WithStats<T>>> inputStreamFactory(BiFunction<Long, Optional<Long>, InputStream> inputStreamFactory) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<Flowable<WithStats<T>>> url(String url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Flowable<Flowable<WithStats<T>>> url(URL url) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static RandomAccessFile createRaf(File f) {
        try {
            return new RandomAccessFile(f, "r");
        } catch (FileNotFoundException e) {
            throw new UncheckedIOException(e);
        }
    }

    private Flowable<T> search(Bounds queryBounds, BiFunction<Long, Optional<Long>, InputStream> inputStreamFactory, int maxRanges, int rangesBufferSize) {
        return Flowable.defer(() -> {
            long[] a = ordinates(queryBounds.mins());
            long[] b = ordinates(queryBounds.maxes());
            Ranges ranges = hc.query(a, b, maxRanges, rangesBufferSize);
            return //
            Flowable.fromIterable(positionRanges(ranges)).flatMap(pr -> search(queryBounds, inputStreamFactory, pr));
        });
    }

    private Flowable<Flowable<T>> searchAdvanced(Bounds queryBounds, BiFunction<Long, Optional<Long>, InputStream> inputStreamFactory, int maxRanges, int rangesBufferSize) {
        return Flowable.defer(() -> {
            long[] a = ordinates(queryBounds.mins());
            long[] b = ordinates(queryBounds.maxes());
            // TODO make hc.query return a Flowable (lazy calculation)?
            Ranges ranges = hc.query(a, b, maxRanges, rangesBufferSize);
            return //
            Flowable.fromIterable(positionRanges(ranges)).map(pr -> search(queryBounds, inputStreamFactory, pr));
        });
    }

    private Flowable<Flowable<WithStats<T>>> searchWithStatsAdvanced(Bounds queryBounds, BiFunction<Long, Optional<Long>, InputStream> inputStreamFactory, int maxRanges, int rangesBufferSize) {
        return Flowable.defer(() -> {
            long[] a = ordinates(queryBounds.mins());
            long[] b = ordinates(queryBounds.maxes());
            Ranges ranges = hc.query(a, b, maxRanges, rangesBufferSize);
            Counts counts = new Counts();
            return //
            Flowable.fromIterable(positionRanges(ranges)).map(//
            pr -> searchWithStats(queryBounds, inputStreamFactory, pr, counts)).concatWith(Flowable.just(finalStats(counts)));
        });
    }

    private Flowable<WithStats<T>> searchWithStats(Bounds queryBounds, BiFunction<Long, Optional<Long>, InputStream> inputStreamFactory, int maxRanges, int rangesBufferSize) {
        return Flowable.defer(() -> {
            long[] a = ordinates(queryBounds.mins());
            long[] b = ordinates(queryBounds.maxes());
            Ranges ranges = hc.query(a, b, maxRanges, rangesBufferSize);
            Counts counts = new Counts();
            return //
            Flowable.fromIterable(positionRanges(ranges)).flatMap(pr -> searchWithStats(queryBounds, inputStreamFactory, pr, counts)).concatWith(finalStats(counts));
        });
    }

    private Flowable<WithStats<T>> finalStats(Counts counts) {
        return Flowable.defer(() -> {
            synchronized (counts) {
                return Flowable.just(new WithStats<T>(null, counts.recordsRead, counts.recordsFound, counts.bytesRead, counts.totalTimeToFirstByte, counts.positionRanges, System.currentTimeMillis() - counts.startTime));
            }
        });
    }

    private static BiFunction<Long, Optional<Long>, InputStream> inputStreamForRange(URL u) {
        return (start, end) -> {
            URLConnection con = u.openConnection();
            String bytesRange = getRangeHeaderValue(start, end);
            con.addRequestProperty("Range", bytesRange);
            return new BufferedInputStream(con.getInputStream());
        };
    }

    @VisibleForTesting
    static String getRangeHeaderValue(long start, Optional<Long> end) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <//
    T> //
    Index<T> //
    createIndex(//
    File input, //
    Serializer<? extends T> serializer, //
    Function<? super T, double[]> point, //
    File output, //
    int bits, //
    int dimensions, //
    int numIndexEntriesApproximate, //
    int sortMaxFiles, //
    int sortMaxItemsPerFile) throws IOException {
        Preconditions.checkArgument(bits * dimensions <= 31, "bits * dimensions must be at most 31");
        // scan once to get the mins, maxes, count
        final double[] mins = new double[dimensions];
        final double[] maxes = new double[dimensions];
        long count = 0;
        try (//
        InputStream in = Util.bufferedInput(input);
            Reader<? extends T> reader = serializer.createReader(in)) {
            Arrays.setAll(mins, i -> Double.MAX_VALUE);
            Arrays.setAll(maxes, i -> Double.MIN_VALUE);
            T t;
            while ((t = reader.read()) != null) {
                count++;
                double[] p = point.apply(t);
                if (p.length != dimensions) {
                    throw new IllegalArgumentException("point function should be of length equal to number of dimensions but was: " + Arrays.toString(p));
                }
                for (int i = 0; i < p.length; i++) {
                    if (p[i] < mins[i]) {
                        mins[i] = p[i];
                    }
                    if (p[i] > maxes[i]) {
                        maxes[i] = p[i];
                    }
                }
            }
        }
        SmallHilbertCurve hc = HilbertCurve.small().bits(bits).dimensions(dimensions);
        //
        Sorter.serializer(//
        serializer).comparator((a, b) -> {
            double[] x = point.apply(a);
            double[] y = point.apply(b);
            return //
            Integer.//
            compare(//
            hilbertIndex(hc, x, mins, maxes), hilbertIndex(hc, y, mins, maxes));
        }).//
        input(//
        input).output(//
        output).maxFilesPerMerge(//
        sortMaxFiles).maxItemsPerFile(//
        sortMaxItemsPerFile).//
        loggerStdOut().sort();
        long chunk = Math.max(1, count / numIndexEntriesApproximate);
        TreeMap<Integer, Long> indexPositions = createIndexPositions(serializer, point, output, mins, maxes, hc, chunk);
        return new Index<T>(indexPositions, mins, maxes, bits, count, serializer, point);
    }

    private static <T> TreeMap<Integer, Long> createIndexPositions(Serializer<T> serializer, Function<? super T, double[]> point, File output, final double[] mins, final double[] maxes, SmallHilbertCurve hc, long chunk) throws IOException, FileNotFoundException {
        TreeMap<Integer, Long> indexPositions = new TreeMap<>();
        try (//
        //
        InputStream in = Util.bufferedInput(output);
            Reader<T> reader = serializer.createReader(in);
            CountingOutputStream counter = new CountingOutputStream();
            Writer<T> writer = serializer.createWriter(counter)) {
            T t;
            long position = 0;
            T lastT = null;
            while ((t = reader.read()) != null) {
                position = counter.count();
                if (position % chunk == 0) {
                    double[] p = point.apply(t);
                    int index = hilbertIndex(hc, p, mins, maxes);
                    if (!indexPositions.containsKey(index)) {
                        // don't overwrite an earlier start position for the index
                        indexPositions.put(index, position);
                    }
                }
                writer.write(t);
                // must flush otherwise position may be wrong for the next pass through the loop
                writer.flush();
                lastT = t;
            }
            if (counter.count() % chunk != 0) {
                // write the last record too so we know index of last position
                double[] p = point.apply(lastT);
                int index = hilbertIndex(hc, p, mins, maxes);
                indexPositions.put(index, position);
            }
        }
        return indexPositions;
    }

    private static int hilbertIndex(SmallHilbertCurve hc, double[] point, double[] mins, double[] maxes) {
        long[] ordinates = new long[point.length];
        for (int i = 0; i < ordinates.length; i++) {
            ordinates[i] = Math.round((point[i] - mins[i]) / (maxes[i] - mins[i]) * hc.maxOrdinate());
        }
        // can do this because bits * dimensions <= 31
        return (int) hc.index(ordinates);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
