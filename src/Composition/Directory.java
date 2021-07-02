package Composition;

import java.util.ArrayList;

public class Directory implements AbstractFile {
    private String name;
    private ArrayList includeFiles = new ArrayList();
    public Directory(String name) {
        this.name = name;
    }

    public void add(Object object){
        includeFiles.add(object);
    }

    @Override
    public void ls() {
        System.out.println(CompositeDemo.compositeBuilder+ name);
        CompositeDemo.compositeBuilder.append("     ");

        for(Object includeFile :includeFiles){
            AbstractFile obj = (AbstractFile) includeFile;
            obj.ls();
        }
        CompositeDemo.compositeBuilder.setLength(CompositeDemo.compositeBuilder.length()-3);
    }
}
