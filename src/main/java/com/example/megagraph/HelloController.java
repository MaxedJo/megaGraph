package com.example.megagraph;


import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class HelloController implements Initializable {

    private PolyLine3D polyLine3D;

    public Canvas mainCanvas;
    public Slider sld1;
    public Group group;
    public Slider scale1;
    public Slider scale2;
    public Slider scale3;
    public Button scale;
    public Slider sld2;
    public Slider sld3;
    public Slider sld4;
    public Slider sld5;
    public Slider sld6;

    public AnchorPane pane;
    float globalX;
    float globalY;
    float globalZ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        float x = 100;
        Point3D p1 = new Point3D(-x, -x, x);
        Point3D p2 = new Point3D(-x, x, x);
        Point3D p3 = new Point3D(x, x, x);
        Point3D p4 = new Point3D(x, -x, x);
        Point3D p5 = new Point3D(-x, -x, -x);
        Point3D p6 = new Point3D(-x, x, -x);
        Point3D p7 = new Point3D(x, x, -x);
        Point3D p8 = new Point3D(x, -x, -x);
        points.add(p1);
        points.add(p2);
        points.add(p3);
        points.add(p4);
        points.add(p1);
        points.add(p5);
        points.add(p6);
        points.add(p2);
        points.add(p6);
        points.add(p7);
        points.add(p3);
        points.add(p7);
        points.add(p8);
        points.add(p4);
        points.add(p8);
        points.add(p5);
        point2.addAll(points);
        polyLine3D = new PolyLine3D(points, 2, Color.RED);
        group.getChildren().addAll(polyLine3D);
//        sld1.valueProperty().addListener((observable,oldValue,newValue)->test());
//        sld2.valueProperty().addListener((observable,oldValue,newValue)->test());
//        sld3.valueProperty().addListener((observable,oldValue,newValue)->test());
        sld4.valueProperty().addListener((observable, oldValue, newValue) -> {
            transform(new float[][]{
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {-globalX, -globalY, -globalZ, 1}});
            transform(new float[][]{
                    {1, 0, 0, 0},
                    {0, (float) Math.cos(sld4.getValue()), (float) Math.sin(sld4.getValue()), 0},
                    {0, -(float) Math.sin(sld4.getValue()), (float) Math.cos(sld4.getValue()), 0},
                    {0, 0, 0, 1}}
            );
            transform(new float[][]{
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {globalX, globalY, globalZ, 1}});
        });
        sld5.valueProperty().addListener((observable, oldValue, newValue) -> {
            transform(new float[][]{
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {-globalX, -globalY, -globalZ, 1}});

            transform(new float[][]{
                    {(float) Math.cos(sld5.getValue()), 0, -(float) Math.sin(sld5.getValue()), 0},
                    {0, 1, 0, 0},
                    {(float) Math.sin(sld5.getValue()), 0, (float) Math.cos(sld5.getValue()), 0},
                    {0, 0, 0, 1}});
            transform(new float[][]{
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {globalX, globalY, globalZ, 1}});
        });
        sld6.valueProperty().addListener((observable, oldValue, newValue) -> {
            transform(new float[][]{
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {-globalX, -globalY, -globalZ, 1}});
            transform(new float[][]{
                    {(float) Math.cos(sld6.getValue()), (float) Math.sin(sld6.getValue()), 0, 0},
                    {-(float) Math.sin(sld6.getValue()), (float) Math.cos(sld6.getValue()), 0, 0},
                    {0, 0, 1, 0},
                    {0, 0, 0, 1}});
            transform(new float[][]{
                    {1, 0, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0},
                    {globalX, globalY, globalZ, 1}});
        });


    }

    ArrayList<Point3D> points = new ArrayList<>();
    ArrayList<Point3D> point2 = new ArrayList<>();


    public void onScale() {
        float x = (float) scale1.getValue();
        float y = (float) scale2.getValue();
        float z = (float) scale3.getValue();
        if (x < 0) x = 1f / x * -1f;
        if (y < 0) y = 1f / y * -1f;
        if (z < 0) z = 1f / z * -1f;
        transform(new float[][]{
                {x, 0, 0, 0},
                {0, y, 0, 0},
                {0, 0, z, 0},
                {0, 0, 0, 1}});
    }

    public void onMX() {
        globalX=-globalX;
        transform(new float[][]{
                {-1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}});
    }

    public void onMY() {
        globalY=-globalY;
        transform(new float[][]{
                {1, 0, 0, 0},
                {0, -1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}});
    }

    public void onMZ() {
        globalZ=-globalZ;
        transform(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, -1, 0},
                {0, 0, 0, 1}});
    }

    public void onMove() {
        float x = (float) sld1.getValue();
        float y = (float) sld2.getValue();
        float z = (float) sld3.getValue();
        globalX += x;
        globalZ += z;
        globalY += y;
        transform(new float[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {x, y, z, 1}});
    }

    public void onClear() {
        globalZ=0;
        globalY=0;
        globalX=0;
        group.getChildren().clear();
        points.clear();
        points.addAll(point2);
        polyLine3D = new PolyLine3D(points, 2, Color.RED);
        group.getChildren().addAll(polyLine3D);
    }

    void transform(float[][] matrix) {
        group.getChildren().clear();
        ArrayList<Point3D> buff = new ArrayList<>();
        for (Point3D point : points) {
            float[] vector = new float[]{point.x, point.y, point.z, 1};
            float[] resultVector = new float[4];
            for (int j = 0; j < 4; j++) {
                for (int i = 0; i < 4; i++) {
                    resultVector[j] += matrix[i][j] * vector[i];
                }
            }
            buff.add(new Point3D(resultVector[0], resultVector[1], resultVector[2]));
        }
        points.clear();
        points.addAll(buff);
        polyLine3D = new PolyLine3D(buff, 2, Color.RED);
        group.getChildren().addAll(polyLine3D);
    }


    void test() {
        group.getChildren().clear();
        ArrayList<Point3D> buff = new ArrayList<>();
//        buff.addAll(points);
        //    points.clear();
        for (Point3D point : points) {
            buff.add(new Point3D((float) (point.x + sld1.getValue()), (float) (point.y + sld2.getValue()), (float) (point.z + sld3.getValue())));
        }
        polyLine3D = new PolyLine3D(buff, 2, Color.RED);
        group.getChildren().addAll(polyLine3D);

    }

    public void onMouseDragged(MouseEvent e) {

        // draw();
    }

    double pX;
    double pY;

    public void onMousePressed(MouseEvent e) {
        pX = e.getX();
        pY = e.getY();
    }

}