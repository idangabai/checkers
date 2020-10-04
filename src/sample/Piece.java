package sample;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static sample.CheckersApp.TILE_SIZE;

public class Piece extends StackPane {

  private PieceType type;

  private double mouseX, mouseY;
  private double oldX, oldY;

    public double getOldX() {
        return oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public Piece(PieceType type, int x, int y){
      this.type = type;

      move(x, y);

      relocate(x * TILE_SIZE, y * TILE_SIZE);

      Ellipse background = new Ellipse(TILE_SIZE *  0.3125, TILE_SIZE * 0.26);
      background.setFill(Color.BLACK);

      background.setStroke(Color.BLACK);
      background.setStrokeWidth(TILE_SIZE * 0.03);

      background.setTranslateX((TILE_SIZE - TILE_SIZE*0.3125*2) / 2);
      background.setTranslateY((TILE_SIZE - TILE_SIZE*0.26*2) / 2 + TILE_SIZE * 0.07 );



      Ellipse ellipse = new Ellipse(TILE_SIZE *  0.3125, TILE_SIZE * 0.26);
      ellipse.setFill(isRed() ?
              Color.valueOf("#c40003") : Color.valueOf("#fff9f4") );

      ellipse.setStroke(Color.BLACK);
      ellipse.setStrokeWidth(TILE_SIZE * 0.03);

      ellipse.setTranslateX((TILE_SIZE - TILE_SIZE*0.3125*2) / 2);
      ellipse.setTranslateY((TILE_SIZE - TILE_SIZE*0.26*2) / 2  );



      getChildren().addAll( background ,ellipse);


      setOnMousePressed(e -> {
          mouseX = e.getSceneX();
          mouseY  = e.getSceneY();
      });

      setOnMouseDragged(e->{
          relocate(e.getSceneX() - mouseX + oldX, e.getSceneY() - mouseY + oldY);
      });

  }


  public  void move(int x, int y){
        oldX  = x*TILE_SIZE;
        oldY  = y*TILE_SIZE;
        relocate(oldX, oldY);
  }


  public void abortMove(){
        relocate(oldX, oldY);
  }


    public PieceType getType() {
        return type;
    }

    private boolean isRed(){
      return type == PieceType.RED;
  }

}