from fpdf import FPDF
#~* To install: pip install fpdf
import os

directory = os.path.dirname(__file__)


class Resume:
    def __init__(self,
                 first_name: str,
                 last_name: str,
                 address: str,
                 email: str,
                 phone: str,
                 education: list[str],
                 skills: list[str],
                 experience: list[str],
                 interests: list[str]
                 ):
        pdf = FPDF(orientation="P", unit="pt", format="A4")
        font_family = "Arial"
        h_line_break = 25
        i_line_break = 50
        l_line_break = 15

        pdf.add_page()
        pdf.set_font(font_family, "", 25)
        pdf.set_left_margin(60)
        pdf.cell(w=5, h=90, txt=f"{first_name} {last_name}")

        email_phone = f"{email}/{phone}"
        pdf.set_font(font_family, "", 10)
        pdf.set_x(350)
        pdf.cell(w=5, h=90, txt=f"{email_phone}")

        pdf.set_line_width(1.5)
        pdf.line(65, 95, 1000, 95)
        pdf.ln()

        pdf.set_font(font_family, "", 25)
        pdf.cell(w=0, h=0, txt="Address")
        pdf.ln(h_line_break)

        pdf.set_font(font_family, "", 15)
        pdf.cell(w=10, h=0, txt=address)
        pdf.ln(i_line_break)

        pdf.set_font(font_family, "", 25)
        pdf.cell(w=0, h=0, txt="Work Experience")
        pdf.ln(h_line_break)

        pdf.set_font(font_family, "", 15)
        for exp in experience:
            pdf.cell(w=10, h=0, txt=exp)
            pdf.ln(l_line_break)
        pdf.ln(i_line_break - l_line_break)

        pdf.set_font(font_family, "", 25)
        pdf.cell(w=0, h=0, txt="Education")
        pdf.ln(h_line_break)

        pdf.set_font(font_family, "", 15)
        for educ in education:
            pdf.cell(w=10, h=0, txt=educ)
            pdf.ln(l_line_break)
        pdf.ln(i_line_break - l_line_break)

        pdf.set_font(font_family, "", 25)
        pdf.cell(w=0, h=0, txt="Skills")
        pdf.ln(h_line_break)

        pdf.set_font(font_family, "", 15)
        for skill in skills:
            pdf.cell(w=10, h=0, txt=skill)
            pdf.ln(l_line_break)
        pdf.ln(i_line_break - l_line_break)

        pdf.set_font(font_family, "", 25)
        pdf.cell(w=0, h=0, txt="Interests")
        pdf.ln(h_line_break)

        pdf.set_font(font_family, "", 15)
        for interest in interests:
            pdf.cell(w=10, h=0, txt=interest)
            pdf.ln(l_line_break)
        pdf.ln(i_line_break - l_line_break)

        pdf.output(name=f"{directory}/sample.pdf", dest="F")


brendan = Resume(
    "Guido",
    "van Rossum",
    "Belmont, California",
    "guido@python.org",
    "1-800-GUIDO",
    ["University of Amsterdam"],
    ["ABC programming language", "Python"],
    ["Centrum Wiskunde & Informatica", "Google", "Dropbox", "Microsoft"],
    ["Hiking", "Biking", "Birding"]
)
