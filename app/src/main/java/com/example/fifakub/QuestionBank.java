package com.example.fifakub;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    private static List<QuestionList> ballQuestions() {
        final List<QuestionList> questionLists = new ArrayList<>();

        //Create Obj quiz
        final QuestionList question1 = new QuestionList("การเเข่งขันฟุตบอลโลกปี 2022 จัดขึ้นที่ประเทศใด", "QATAR", "RUSSIA", "BRAZIL", "THAILAND", "QATAR", "");
        final QuestionList question2 = new QuestionList("ประเทศที่เข้าร่วมการเเข่งขันฟุตบอลโลกปี 2022 มีกี่ประเทศ", "30", "38", "36", "32", "32", "");
        final QuestionList question3 = new QuestionList("ลูกฟุตบอลที่ใช้ในการแข่งขันฟุตบอลโลกปี 2022 ชื่อว่าอะไร", "Telstar 18", "Al Rihla", "Brazuca", "Jabulani", "Al Rihla", "");
        final QuestionList question4 = new QuestionList("สีหลักประจำการเเข่งขันฟุตบอลโลกปี 2022 คือ", "Dark Scarlet", "DarkRed", "FireBrick", "Red", "Dark Scarlet", "");
        final QuestionList question5 = new QuestionList("สนามทั้งหมดของการเเข่งขันฟุตบอลโลกปี 2022 มีกี่สนาม", "6", "8", "10", "12", "8", "");
        final QuestionList question6 = new QuestionList("เพลงประจำการแข่งขันฟุตบอลโลก 2022 อย่างเป็นทางการ มีชื่อว่าอะไร?", "Waka Waka", "We are one", "Hayya Hayya", "Live it up", "Hayya Hayya", "");
        final QuestionList question7 = new QuestionList("การเเข่งขันฟุตบอลโลกปี 2022 จัดขึ้นระหว่างวันที่เท่าไหร่", "14 พ.ย.- 15 ธ.ค.2022", "21 พ.ย.- 18 ธ.ค.2022", "20 พ.ย.- 20 ธ.ค.2022", "1 พ.ย.- 30 ธ.ค.2022", "21 พ.ย.- 18 ธ.ค.2022", "");
        final QuestionList question8 = new QuestionList("Mitrovic ชื่อจริงของเขาชื่ออะไร", "Kevin", "Darwin", "Granit", "Aleksandar", "Aleksandar", "");
        final QuestionList question9 = new QuestionList("Hannibal Mejbri คือนักฟุตบอลของประเทศอะไร", "Serbia", "Tunisia", "Russia", "Australia", "Tunisia", "");
        final QuestionList question10 = new QuestionList("ชุดของทีมชาติ Japan สีอะไร", "ฟ้า", "ขาว", "เเดง", "น้ำเงิน", "น้ำเงิน", "");

        //add all quiz to List<questionLists>
        questionLists.add(question1);
        questionLists.add(question2);
        questionLists.add(question3);
        questionLists.add(question4);
        questionLists.add(question5);
        questionLists.add(question6);
        questionLists.add(question7);
        questionLists.add(question8);
        questionLists.add(question9);
        questionLists.add(question10);

        return questionLists;


    }
    public static List<QuestionList> getQuestions(){
        return ballQuestions();
    }
}
