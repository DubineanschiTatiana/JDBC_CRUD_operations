package utils;

public class RelativePathTransformer {
    public static String getRelativePath(String filename){
        ClassLoader classLoader = RelativePathTransformer.class.getClassLoader();
        return classLoader.getResource("bikeProducts.csv").getPath().substring(1);
    }
}
