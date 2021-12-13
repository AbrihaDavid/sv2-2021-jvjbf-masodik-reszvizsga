package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanFileManager {

    List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path){
        try {
            List<String> names = Files.readAllLines(path);
            for (String s: names){
                String[] temp = s.split(";");
                humans.add(new Human(temp[0],temp[1]));
            }
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path){
        List<String> males = new ArrayList<>();

        for (Human human: humans){
            if(human.getIdentityNumber().startsWith("1") || human.getIdentityNumber().startsWith("3")){
                StringBuilder sb = new StringBuilder();
                males.add(sb.append(human.getName()).append(";").append(human.getIdentityNumber()).toString());
            }
        }
        try {
            Files.write(path, males);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }
}
