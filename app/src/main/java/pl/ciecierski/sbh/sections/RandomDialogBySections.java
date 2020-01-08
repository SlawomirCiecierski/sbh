package pl.ciecierski.sbh.sections;

import static pl.ciecierski.sbh.sections.Sections.*;


public class RandomDialogBySections {

    public static String showRandomDialogBySection(Sections sections) {
//        todo using CASE
RandomDialogFromSection randomDialogFromSection= new RandomDialogFromSection();

       return randomDialogFromSection.getRandomDialogFromSection(sections);



    }
}
