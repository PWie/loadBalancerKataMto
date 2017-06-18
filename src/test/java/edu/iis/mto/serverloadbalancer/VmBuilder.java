package edu.iis.mto.serverloadbalancer;

/**
 * Created by Patryk Wierzyński
 */

public class VmBuilder {

	private int size;

	public VmBuilder ofSize(int size) {
		this.size = size;
		return this;
	}

	public Vm build() {
		return new Vm();
	}
}
