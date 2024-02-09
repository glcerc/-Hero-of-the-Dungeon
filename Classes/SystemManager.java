package com.company.Classes;

import com.company.Interfaces.System_;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public abstract class SystemManager implements System_ {

    public SystemManager() {
        File myObj = new File(System.getProperty("user.dir")+"\\LeaderBoard.txt");
        try {
            if(myObj.createNewFile()){
             for(int i = 0; i < 5; i++){
                 writeToPosition("Empty,0,0",i,false);

             }
            }


        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int scannerTakeIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        int number;
        String input;
        while(true){
            input = scanner.nextLine();
            if(input.length() > 0){
                try{
                    number = Integer.parseInt(input);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("You just have to enter numbers. Try again:");
                }
            }else{
                System.out.println("You just have to enter numbers. Try again:");
            }
        }
        return number;
    }

    @Override
    public int scannerSelectedRangeControlForInt(List<Integer> args, int input) {
        int number = input;
        int cond = 0;
        while (true){
            if(args.size() == 0)
                break;
            for (int item: args
            ) {
                if(item == number){
                    cond = 1;
                    break;
                }
            }
            if(cond == 1){
                break;
            }else{
                System.out.println("Try again:");
                number = this.scannerTakeIntegerInput();
            }
        }

        return number;
    }

    @Override
    public void detectLeaderBoard(String herosName, int valueOfItems, int numberOfRescue) {
        FileInputStream fis= null;
        File tmpDir = null;
        tmpDir = new File(System.getProperty("user.dir")+"\\src\\com\\company\\Datas\\LeaderBoard.txt");
        Path path;
        long lines = 0;
        try {
            if(tmpDir.exists()){
                path = Paths.get(System.getProperty("user.dir")+"\\src\\com\\company\\Datas\\LeaderBoard.txt");
            }else{
                path = Paths.get(System.getProperty("user.dir")+"\\LeaderBoard.txt");
            }

            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(tmpDir.exists()){
                fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\company\\Datas\\LeaderBoard.txt");

            }else{
                fis = new FileInputStream(System.getProperty("user.dir")+"\\LeaderBoard.txt");

            }
            Scanner sc=new Scanner(fis);
            int outterCount = 0;
            if(lines  < 5){
                writeToPosition(herosName+","+valueOfItems+","+numberOfRescue,Integer.parseInt(String.valueOf(lines)),false);
            }else{
                while(sc.hasNextLine())
                {
                    int itemsValue = 0;
                    int numbersRescue = 0;
                    int count = 0;
                    for (String item:
                            sc.nextLine().split(",")) {
                        if(count == 1){
                            itemsValue = Integer.parseInt(item);
                        }else if(count == 2){
                            numbersRescue = Integer.parseInt(item);
                        }

                        count++;
                    }
                    if((itemsValue+(numbersRescue*5) < (valueOfItems+(numberOfRescue*5)))){
                        writeToPosition(herosName+","+valueOfItems+","+numberOfRescue,outterCount, true);
                        break;
                    }
                    outterCount++;
                }
            }
            sc.close();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void writeToPosition(String data, int position, boolean state)
            throws IOException, URISyntaxException {
        File tmpDir = new File(System.getProperty("user.dir")+ "\\src\\com\\company\\Datas\\LeaderBoard.txt");
        List<String> lines;
        if(tmpDir.exists()){
            lines = Files.readAllLines(Path.of(System.getProperty("user.dir") + "\\src\\com\\company\\Datas\\LeaderBoard.txt"));

        }else{
            lines = Files.readAllLines(Path.of(System.getProperty("user.dir") + "\\LeaderBoard.txt"));
        }
        if(state)
            lines.set(position, data);
        else
            lines.add(position,data);
        if(tmpDir.exists()){
            Files.write(Path.of(System.getProperty("user.dir") + "\\src\\com\\company\\Datas\\LeaderBoard.txt"), lines);

        }else {
            Files.write(Path.of(System.getProperty("user.dir") + "\\LeaderBoard.txt"), lines);
        }

    }


}

