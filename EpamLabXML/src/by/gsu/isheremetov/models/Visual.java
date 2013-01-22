package by.gsu.isheremetov.models;

class Visual {
	private int width;
	private int height;
	private String material;
	private String handleKind;
	private String handleMaterial;
	private boolean krovostok;

	protected Visual() {
		setWidth(0);
		setHeight(0);
		setMaterial("");
		setHandleKind("");
		setHandleMaterial("");
		setKrovostok(false);
	}

	protected Visual(int width, int height, String material, String handleKind,
			String handleMaterial, boolean krovostok) {
		setWidth(width);
		setHeight(height);
		setMaterial(material);
		setHandleKind(handleKind);
		setHandleMaterial(handleMaterial);
		setKrovostok(krovostok);
	}

	protected int getWidth() {
		return width;
	}

	protected void setWidth(int width) {
		this.width = width;
	}

	protected int getHeight() {
		return height;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	protected String getMaterial() {
		return material;
	}

	protected void setMaterial(String material) {
		this.material = material;
	}

	protected String getHandleKind() {
		return handleKind;
	}

	protected void setHandleKind(String handleKind) {
		this.handleKind = handleKind;
	}

	protected String getHandleMaterial() {
		return handleMaterial;
	}

	protected void setHandleMaterial(String handleMaterial) {
		this.handleMaterial = handleMaterial;
	}

	protected boolean isKrovostok() {
		return krovostok;
	}

	protected void setKrovostok(boolean krovostok) {
		this.krovostok = krovostok;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ширина лезвия: ");
		sb.append(getWidth());
		sb.append("\n");
		sb.append("Длинна лезвия: ");
		sb.append(getHeight());
		sb.append("\n");
		sb.append("Материал клинка: ");
		sb.append(getMaterial());
		sb.append("\n");
		sb.append("Материал рукояти: ");
		sb.append(getHandleKind() != "" ? getHandleMaterial() + " "
				+ getHandleKind() : getHandleMaterial());
		sb.append("\n");
		sb.append("Кровосток: ");
		sb.append(isKrovostok() ? "есть" : "нету");
		return sb.toString();
	}

}
