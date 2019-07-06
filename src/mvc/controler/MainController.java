package mvc.controler;

import mvc.controler.impl.CalculationImpl;
import mvc.model.FileHandler;
import mvc.model.impl.MainModel;
import mvc.view.MainView;
import mvc.view.impl.MainViewImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private FileHandler model;
    private MainView view;
    private Calculation calculation;
    private Scanner scanner;
    private List<File> files;
    private List<String> timeList;
    private List<List<Integer>> queues;


    public MainController(String[] args) {
        model = new MainModel();
        calculation = new CalculationImpl();
        files = new ArrayList<>();
        queues = new ArrayList<>();
        view = new MainViewImpl();
        scanner = new Scanner(System.in);
        run(args);
    }

    private void run(String[] args) {
        if (args.length != 0){
            acceptArguments(args);
        } else {
            requestArguments();
        }

        for (int i = 0; i < files.size(); i++) {
            if (i != 5){
                queues.add(model.processFileToIntegerList(files.get(i)));
            }
            timeList = model.processFileToStringList(files.get(i));
        }

        view.biggestQeue(calculation.biggestQueue(queues, timeList));

    }

    private void acceptArguments(String[] args) {
        for (int i = 0; i < args.length; i++) {
            files.add(model.getFilePath(args[i]));
        }
    }

    private void requestArguments(){
        for (int i = 1; i <= 5; i++) {
            view.enterThePath(i);
            files.add(model.getFilePath(scanner.nextLine()));
        }
        view.enterFileWithTimeIntervals();
        files.add(model.getFilePath(scanner.nextLine()));
    }
}
