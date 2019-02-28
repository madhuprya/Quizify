package com.stackroute.quizify.gamemanager.component;

import com.stackroute.quizify.gamemanager.exception.GameAlreadyExists;
import com.stackroute.quizify.kafka.domain.Admin;
import com.stackroute.quizify.kafka.domain.Category;
import com.stackroute.quizify.kafka.domain.Game;
import com.stackroute.quizify.kafka.domain.Topic;
import com.stackroute.quizify.gamemanager.service.GameService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

@Component
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent>
{
    private GameService gameService;
    private Admin admin;
    private Category category1;
    private Topic topic1;
    private Game game;

    private Environment environment;

    @Autowired
    public FeedDataApplicationListener(Environment environment, GameService gameService) {
        this.environment = environment;
        this.gameService = gameService;
        /**
         * Dummy Data For Admin Class
         *
         */


        this.admin = new Admin();
        this.admin.setId(Long.parseLong(environment.getProperty("admin.id")));
        this.admin.setName(environment.getProperty("admin.name"));

        /**
         * Dummy Data For Category Class
         */
        this.category1 = new Category();
        this.category1.setId(Long.parseLong(environment.getProperty("domain.category1.id")));
        this.category1.setName(environment.getProperty("domain.category1.name"));
        this.category1.setImageUrl(environment.getProperty("domain.category1.image.url"));
        this.category1.setTimeStamp(""+System.currentTimeMillis());
        this.category1.setAdmin(this.admin);
        /**
         * Dummy Data For Topic Class
         */
        this.topic1 = new Topic();
        this.topic1.setId(Long.parseLong(environment.getProperty("category1.topic1.id")));
        this.topic1.setName(environment.getProperty("category1.topic1.name"));
        this.topic1.setImageUrl(environment.getProperty("category1.topic1.image.url"));
        this.topic1.setTimeStamp(""+System.currentTimeMillis());
        this.topic1.setAdmin(this.admin);
        /**
         * Dummy Data For Game Class
         */
        this.game = new Game();

    };

//    @Value("com/stackroute/quizify/questionmanager/data/MoviesBasicAll.xlsx")
//    private Resource resource;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        File file = new File("./assets/GameMovies.xlsx");
//        System.out.println("-----------------------------------------------------------------------"+file.exists());


        try
        {
            // Finds the XLSX file
//           Resource resource = new ClassPathResource("data/MoviesBasicAll.xlsx");

            // Finds the workbook instance for XLSX file

            XSSFWorkbook myWorkBook = new XSSFWorkbook(new FileInputStream(file));
            // Return first sheet from the XLSX workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            // Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = mySheet.iterator();
            // Traversing over each row of XLSX file
            rowIterator.next();//Skipping 1st line
            int j=0;
            while (rowIterator.hasNext()) {
//                System.out.println();
//                System.out.println("Running : ");
//                System.out.println(++j);
//                System.out.println();
                Row row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                game.setId(0);
                for (int i=1; cellIterator.hasNext(); i++)
                {
                    cell = cellIterator.next();
                    String cellType = "" + cell.getCellType();
                    switch (i)
                    {
                        case 1:
                            this.game.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            this.game.setCategory(this.category1);
                            break;
                        case 3:
                            this.game.setTopic(this.topic1);
                            break;
                        case 4:
                            this.game.setTag(cell.getStringCellValue());
                            break;
                        case 5:
                            this.game.setLevel(cell.getStringCellValue());
                            break;
                        case 6:
                            this.game.setImageUrl(cell.getStringCellValue());
                            break;
                        case 7:
                            this.game.setNumOfQuestion((int)cell.getNumericCellValue());
                            break;
                        case 8:
                            this.game.setRules(cell.getStringCellValue());
                            break;
                        case 9:
                            this.game.setTimeDuration((long)cell.getNumericCellValue());
                            break;
                    }

                }
//                System.out.println("******************************************************************************");
//                System.out.println("Created : ");
//                System.out.println(this.game);
                this.game.setAdmin(this.admin);
                this.gameService.saveGame(this.game);
            }
        }
        catch (IOException | GameAlreadyExists e)
        {
            e.printStackTrace();
        }

//        File file = new File("./assets/MoviesBasicAll.csv");


    }
}
