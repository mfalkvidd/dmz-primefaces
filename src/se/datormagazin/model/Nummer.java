package se.datormagazin.model;

public class Nummer {

	private String namn;
	private String bildUrl;
	private String beskrivning;

	public Nummer(String namn, String bildUrl, String beskrivning) {
		this.setNamn(namn);
		this.setBildUrl(bildUrl);
		this.setBeskrivning(beskrivning);
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String getBildUrl() {
		return bildUrl;
	}

	public void setBildUrl(String bildUrl) {
		this.bildUrl = bildUrl;
	}

	public String getBeskrivning() {
		return beskrivning;
	}

	public void setBeskrivning(String beskrivning) {
		this.beskrivning = beskrivning;
	}

}
