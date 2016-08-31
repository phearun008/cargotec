package cargotecv3;

import java.util.List;

public class Content {
	private int id;
	private String chapter;
	private String description;
	private String re;
	private String page;
	
	private SectionImage sectionImage;
	private List<SectionDescription> sectionDescription;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRe() {
		return re;
	}
	public void setRe(String re) {
		this.re = re;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public SectionImage getSectionImage() {
		return sectionImage;
	}
	public void setSectionImage(SectionImage sectionImage) {
		this.sectionImage = sectionImage;
	}
	public List<SectionDescription> getSectionDescription() {
		return sectionDescription;
	}
	public void setSectionDescription(List<SectionDescription> sectionDescription) {
		this.sectionDescription = sectionDescription;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", chapter=" + chapter + ", description=" + description + ", re=" + re + ", page="
				+ page + ", sectionImage=" + sectionImage + ", sectionDescription=" + sectionDescription + "]";
	}
	
	
}
