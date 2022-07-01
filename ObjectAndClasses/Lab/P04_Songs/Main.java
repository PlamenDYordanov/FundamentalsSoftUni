package ProgrammingFundamentals.ObjectAndClasses.Lab.P04_Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        List<Songs> songsList = new ArrayList<>();



        for (int i = 0; i < numberOfSongs; i++) {

            String inputSong = scanner.nextLine();
            String  typeList = inputSong.split("_")[0];
            String  name = inputSong.split("_")[1];
            String time = inputSong.split("_")[2];
            Songs songs = new Songs(typeList,name,time);
            songsList.add(songs);


        }
            String requireTypeList = scanner.nextLine();
        if (requireTypeList.equals("all")){
            for (Songs songs : songsList) {
                System.out.println(songs.getName());
            }

        }else {
            for (Songs songs : songsList) {
                if (requireTypeList.equals(songs.getTypeList())){
                    System.out.println(songs.getName());
                }
            }

        }


    }
}
