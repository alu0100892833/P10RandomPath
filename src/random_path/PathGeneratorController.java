package random_path;


public class PathGeneratorController {
    private PathModel model;
    private RandomPathView view;

    public PathGeneratorController() {
        model = new PathModel();
        view = new RandomPathView(model);
        view.setVisible(true);
    }
    
    @SuppressWarnings("unused")
	public static void main(String[] args) {
        PathGeneratorController controller = new PathGeneratorController();
        System.out.println();
    }
}
