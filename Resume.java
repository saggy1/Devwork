import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class Resume {


  String firstName,      lastName,       address,      email,     phone;
     ArrayList<String> education = new ArrayList<>();
     ArrayList<String> skills = new ArrayList<>();
     ArrayList<String> experience =new ArrayList<>();
     ArrayList<String> interests=new ArrayList<>();
public Resume addFirstName(String firstName){this.firstName=firstName; return this;}
public Resume addLastName(String lastName){this.lastName=lastName;return this;}
public Resume addAddress(String address){this.address=address;return this;}
public Resume addEmail(String email){this.email=email;return this;}
public Resume addPhone(String phone){this.phone=phone;return this;}
public Resume addEducation(String education){ this.education.add(education);return this;}
// add Education should be added in one go using push method
public Resume addSkills(String skills) { this.skills.add(skills);return this;}
public Resume addExperience(String experience){this.experience.add(experience);return this;};
public Resume addInterests(String interests ){ this.interests.add(interests);return this;}

public Resume build() throws Exception{
 var pdf = new Document();
    PdfWriter.getInstance(pdf, new FileOutputStream("resume.pdf"));
    pdf.open();
    pdf.newPage();
    var paraFont = new Font(FontFamily.HELVETICA, 16f);
    var header = firstName + "  " + lastName + "      " + email + "/" + phone;
    var para = new Paragraph(header, paraFont);
    pdf.add(para);
    pdf.add(Chunk.NEWLINE);
    pdf.add(new LineSeparator());
    pdf.add(Chunk.NEWLINE);

    pdf.add(new Paragraph("Address", paraFont));
    pdf.add(new Phrase(address));
    pdf.add(Chunk.NEWLINE);
    pdf.add(Chunk.NEWLINE);
    
    pdf.add(new Paragraph("Education", paraFont));
    for (var edu : education) {
      pdf.add(new Phrase(edu));
    }
    pdf.add(Chunk.NEWLINE);
    pdf.add(Chunk.NEWLINE);
    
    pdf.add(new Paragraph("Skills", paraFont));
    for (var skill : skills) {
      pdf.add(new Phrase(skill));
      pdf.add(Chunk.NEWLINE);
    }
    pdf.add(Chunk.NEWLINE);

    pdf.add(new Paragraph("Experience", paraFont));
    for (var exp : experience) {
      pdf.add(new Phrase(exp));
      pdf.add(Chunk.NEWLINE);
    }
    pdf.add(Chunk.NEWLINE);

    pdf.add(new Paragraph("Interests", paraFont));
    for (var interest : interests) {
      pdf.add(new Phrase(interest));
      pdf.add(Chunk.NEWLINE);
    }
    pdf.add(Chunk.NEWLINE);

    pdf.close();
    return this;
}

public String toString

   /* var pdf = new Document();
    PdfWriter.getInstance(pdf, new FileOutputStream("resume.pdf"));
    pdf.open();
    pdf.newPage();
    var paraFont = new Font(FontFamily.HELVETICA, 16f);
    var header = firstName + "  " + lastName + "      " + email + "/" + phone;
    var para = new Paragraph(header, paraFont);
    pdf.add(para);
    pdf.add(Chunk.NEWLINE);
    pdf.add(new LineSeparator());
    pdf.add(Chunk.NEWLINE);

    pdf.add(new Paragraph("Address", paraFont));
    pdf.add(new Phrase(address));
    pdf.add(Chunk.NEWLINE);
    pdf.add(Chunk.NEWLINE);
    
    pdf.add(new Paragraph("Education", paraFont));
    for (var edu : education) {
      pdf.add(new Phrase(edu));
    }
    pdf.add(Chunk.NEWLINE);
    pdf.add(Chunk.NEWLINE);
    
    pdf.add(new Paragraph("Skills", paraFont));
    for (var skill : skills) {
      pdf.add(new Phrase(skill));
      pdf.add(Chunk.NEWLINE);
    }
    pdf.add(Chunk.NEWLINE);

    pdf.add(new Paragraph("Experience", paraFont));
    for (var exp : experience) {
      pdf.add(new Phrase(exp));
      pdf.add(Chunk.NEWLINE);
    }
    pdf.add(Chunk.NEWLINE);

    pdf.add(new Paragraph("Interests", paraFont));
    for (var interest : interests) {
      pdf.add(new Phrase(interest));
      pdf.add(Chunk.NEWLINE);
    }
    pdf.add(Chunk.NEWLINE);

    pdf.close();*/ 


  //}

  public static void main(String[] args) throws Exception {

    var resume = new Resume(
        "James",
        "Gosling",
        "CA US",
        "jamesgosling@gmail.com",
        "1-800-GOSLING",
        new String[] { "BE" },
        new String[] { "Java" },
        new String[] { "Sun", "Oracle" },
        new String[] { "Arts" });
  }
}
