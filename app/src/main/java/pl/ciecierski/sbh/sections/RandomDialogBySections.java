package pl.ciecierski.sbh.sections;




public class RandomDialogBySections {

    public static String showRandomDialogBySection(Sections sections) {

RandomTextFromSection randomTextFromSection = new RandomTextFromSection();

       return randomTextFromSection.getRandomDialogFromSection(sections);



    }
}
