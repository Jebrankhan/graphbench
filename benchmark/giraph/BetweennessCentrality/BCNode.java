package org.apache.giraph.io.formats;

/*
This class is adjusted according to the output generated by Green-Marl compiler
*/
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.LongWritable;
import java.util.*;

public class BCNode implements Writable {
	// properties
	public float BC;
	public float sigma;
	public float delta;
	public float __S3prop;
	public int level;
	public ArrayList<LongWritable> revNodeId; // reverse edges (node IDs)

	public BCNode() {
		// Default constructor needed for Giraph
		revNodeId = new ArrayList<LongWritable>();
	}

	// Initalize with initData
	public BCNode(float bc) {
		BC = bc;
	}

	public float getBC() {
		return BC;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeFloat(BC);
		out.writeFloat(sigma);
		out.writeFloat(delta);
		out.writeFloat(__S3prop);
		out.writeInt(level);
		out.writeInt(revNodeId.size());
		for (LongWritable node : revNodeId) {
			node.write(out);
		}
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		BC = in.readFloat();
		sigma = in.readFloat();
		delta = in.readFloat();
		__S3prop = in.readFloat();
		level = in.readInt();
		int _node_count = in.readInt();
		revNodeId = new ArrayList<LongWritable>();
		for (int i = 0; i < _node_count; i++) {
			revNodeId.get(i).readFields(in);
		}
	}

	@Override
	public String toString() {
		return "" + BC;
	}
}