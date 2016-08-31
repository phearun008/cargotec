package cargotecv3.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import cargotecv3.Content;
import cargotecv3.Description;
import cargotecv3.SectionDescription;

public class Cargotec {

	public List<Content> readContentList(String fileUrl, int sheetNumber, Integer[] startRow, Integer[] endRow)
			throws Exception {

		FileInputStream inputStream = new FileInputStream(new File(fileUrl));
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheetAt(sheetNumber);

		if (startRow.length != endRow.length)
			throw new Exception("[==> Message]: startRow & endRow does not match!!");

		List<Content> contentLists = new ArrayList<>();
		for (int i = 0; i < startRow.length; i++) {
			List<Content> contentList = readBetween(sheet, startRow[i], endRow[i]);
			contentLists.addAll(contentList);
		}

		return contentLists;
	}

	private List<Content> readBetween(Sheet sheet, int startRow, int endRow) {
		List<Content> contentList = new ArrayList<>();
		startRow = startRow - 1;
		endRow = endRow - 1;

		for (int row = startRow; row <= endRow; row++) {
			HSSFRow r = (HSSFRow) sheet.getRow(row);

			Content content = new Content();
			content.setChapter(((r.getCell(0) + "").replace(".0", "")));
			content.setDescription(r.getCell(1).toString());
			content.setRe(r.getCell(2).toString());
			content.setPage(r.getCell(3).toString());

			contentList.add(content);
		}
		return contentList;
	}

	public void readSectionImage(String fileUrl, int sheetNumber) throws Exception {

	}

	public List<SectionDescription> readSectionDescriptions(String fileUrl, int sheetNumber, int startRow)
			throws Exception {

		FileInputStream inputStream = new FileInputStream(new File(fileUrl));
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheetAt(sheetNumber);

		List<SectionDescription> sectionDescriptions = new ArrayList<>();

		for (int j = 0; j<30; j++) {
			SectionDescription sd = this.readSectionDescription(sheet, startRow);
			sectionDescriptions.add(sd);

			// Step up to next description
			startRow += 72;
			
			if(sheet.getRow(startRow).getCell(0).toString()==""){
				System.err.println(111);
			};
		}
		return sectionDescriptions;
	}

	private SectionDescription readSectionDescription(Sheet sheet, int startRow) {
		System.out.println("Start Row: " + startRow);
		SectionDescription sectionDescription = new SectionDescription();

		HSSFRow r = (HSSFRow) sheet.getRow(startRow);
		String section = r.getCell(0).toString();
		System.out.println(section);
		// goto description row
		int descriptionMetaRow = startRow + 1;
		r = (HSSFRow) sheet.getRow(descriptionMetaRow);
		String title = r.getCell(0).toString();
		String number = r.getCell(5).toString();

		int descriptionRow = descriptionMetaRow + 2;
		r = (HSSFRow) sheet.getRow(descriptionRow);

		List<Description> descriptions = new ArrayList<>();
		for (int row = descriptionRow; r.getCell(0).toString() != ""; row++) {
			Description description = new Description();
			description.setPos(r.getCell(0).toString());
			description.setQty(Integer.parseInt(r.getCell(1).toString().replace(".0", "")));
			description.setPartNo(r.getCell(2).toString());
			description.setDescription(r.getCell(3).toString());
			description.setRemark(r.getCell(4).toString());

			descriptions.add(description);

			r = (HSSFRow) sheet.getRow(row + 1);
		}
		// goto page row
		r = (HSSFRow) sheet.getRow(startRow + 35);

		sectionDescription.setPage(r.getCell(0).toString());
		sectionDescription.setDescription(descriptions);
		sectionDescription.setSection(section);
		sectionDescription.setTitle(title);
		sectionDescription.setNumber(number);

		return sectionDescription;
	}

	public static void main(String[] args) throws Exception {
		String fileUrl = "D:/Cargotec/cargotec/HIAB18000XGR (201603).xls";

		/*
		 * List<Content> contentList = new Cargotec().readContentList(fileUrl,
		 * 1, new Integer[] { 3, 39 }, new Integer[] { 34, 70 });
		 * 
		 * contentList.forEach(content -> { System.out.println(content); });
		 */

		List<SectionDescription> sectionDescription = new Cargotec().readSectionDescriptions(fileUrl, 0, 36);
		sectionDescription.forEach(s -> {
			System.out.println(s);
		});

	}
}
