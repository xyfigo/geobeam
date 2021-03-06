package gtl.beam.partitioning;

import gtl.geom.Envelope;
import gtl.geom.Vector;
import gtl.index.kdtree.KDTree;

import java.io.Serializable;
import java.util.List;

public class KDTreePartitioning<E extends Envelope, V extends Vector>
        extends SpatialPartitioning<E> implements Serializable {

    private static final long serialVersionUID=1L;

    KDTree<V> kdTree;

    KDTreePartitioning(E totalExtent, List<V> samplePoints){
        super(totalExtent);
        kdTree = KDTree.create(totalExtent,(List<Vector>)samplePoints);
        this.partitionEnvelopes.clear();
        this.partitionEnvelopes.addAll(kdTree.getPartitionEnvelopes());
    }

    KDTreePartitioning(E totalExtent, Iterable<V> samplePoints){
        super(totalExtent);
        kdTree = KDTree.create(totalExtent,(List<Vector>)samplePoints);
        this.partitionEnvelopes.clear();
        this.partitionEnvelopes.addAll(kdTree.getPartitionEnvelopes());
    }
}
