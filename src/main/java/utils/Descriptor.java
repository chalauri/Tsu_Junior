package utils;

public class Descriptor {

	private Boolean valid;
	private String description;

	public static Descriptor validDescriptor() {
		Descriptor desc = new Descriptor();
		desc.setValid(true);

		return desc;
	}

	public static Descriptor validDescriptor(String description) {
		Descriptor desc = new Descriptor();
		desc.setValid(true);
		desc.setDescription(description);

		return desc;
	}

	public static Descriptor invalidDescriptor() {
		Descriptor desc = new Descriptor();
		desc.setValid(false);

		return desc;
	}

	public static Descriptor invalidDescriptor(String description) {
		Descriptor desc = new Descriptor();
		desc.setValid(false);
		desc.setDescription(description);

		return desc;
	}

	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
