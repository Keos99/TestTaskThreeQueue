package mvc.view.impl;

import mvc.view.MainView;

public class MainViewImpl implements MainView {
    @Override
    public void enterThePath(int queuenumber) {
        System.out.println("Введите путь к " + queuenumber + " файлу:");
    }

    @Override
    public void biggestQeue(String time) {
        System.out.println("Самая большая очередь была в " + time);
    }

    @Override
    public void enterFileWithTimeIntervals() {
        System.out.println("Введите путь к файлу с временными отрезками:");
    }
}
