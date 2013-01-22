package by.gsu.isheremetov.models;

public class Weapon {
	private String type;
	private String handy;
	private String origin;
	private Visual visual;
	private boolean value;

	public Weapon() {
		setType("");
		setHandy("");
		setOrigin("");
		visual = new Visual();
		setValue(false);
	}

	public Weapon(String type, String handy, String origin, int width,
			int height, String material, String handleKind,
			String handleMaterial, boolean krovostok, boolean value) {
		setType(type);
		setHandy(handy);
		setOrigin(origin);
		visual = new Visual(width, height, material, handleKind,
				handleMaterial, krovostok);
		setValue(value);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHandy() {
		return handy;
	}

	public void setHandy(String handy) {
		this.handy = handy;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	// <Visual>

	public int getWidth() {
		return visual.getWidth();
	}

	public void setWidth(int width) {
		visual.setWidth(width);
	}

	public int getHeight() {
		return visual.getHeight();
	}

	public void setHeight(int height) {
		visual.setHeight(height);
	}

	public String getMaterial() {
		return visual.getMaterial();
	}

	public void setMaterial(String material) {
		visual.setMaterial(material);
	}

	public String getHandleKind() {
		return visual.getHandleKind();
	}

	public void setHandleKind(String handleKind) {
		visual.setHandleKind(handleKind);
	}

	public String getHandleMaterial() {
		return visual.getHandleMaterial();
	}

	public void setHandleMaterial(String handleMaterial) {
		visual.setHandleMaterial(handleMaterial);
	}

	public boolean isKrovostok() {
		return visual.isKrovostok();
	}

	public void setKrovostok(boolean krovostok) {
		visual.setKrovostok(krovostok);
	}

	// </Visual>

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Оружие: ");
		sb.append(getType());
		sb.append("\n");
		sb.append("Тип: ");
		sb.append(getHandy());
		sb.append("\n");
		sb.append("Производитель: ");
		sb.append(getOrigin());
		sb.append("\n");
		sb.append(visual.toString());
		sb.append("\n");
		sb.append(isValue() ? "Коллекционное" : "Не коллекционное");
		return sb.toString();
	}

}
