/*
 * Copyright (C) 2013-2015 F(X)yz,
 * Sean Phillips, Jason Pollastrini and Jose Pereda
 * All rights reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.example.megagraph;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;



/**
 *
 * @author Sean
 */
public class Hello extends Application {
    private PerspectiveCamera camera;
    private final double sceneWidth = 600;
    private final double sceneHeight = 600;
    private double cameraDistance = 5000;
    private PolyLine3D polyLine3D;
    private double scenex, sceney, scenez = 0;
    private double fixedXAngle, fixedYAngle, fixedZAngle = 0;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);
    private final DoubleProperty angleZ = new SimpleDoubleProperty(0);

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane sceneRoot = new BorderPane();
        Scene scene = new Scene(sceneRoot, sceneWidth, sceneHeight, true, SceneAntialiasing.BALANCED);
        scene.setFill(Color.BLACK);
//        camera = new PerspectiveCamera(true);
//        camera.setNearClip(0.1);
//        camera.setFarClip(10000.0);
//        camera.setTranslateZ(-1000);
//        scene.setCamera(camera);

        ArrayList<Point3D> points = new ArrayList<>();
        float x = 100;
        Point3D p1 = new Point3D(-x,-x,x);
        Point3D p2 = new Point3D(-x,x,x);
        Point3D p3 = new Point3D(x,x,x);
        Point3D p4 = new Point3D(x,-x,x);
        Point3D p5 = new Point3D(-x,-x,-x);
        Point3D p6 = new Point3D(-x,x,-x);
        Point3D p7 = new Point3D(x,x,-x);
        Point3D p8 = new Point3D(x,-x,-x);
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


        polyLine3D = new PolyLine3D(points,2,Color.RED);
        Slider s1 = new Slider(0,180,0);
        sceneRoot.setCenter(polyLine3D);
        sceneRoot.setRight(s1);
//        sceneRoot.getChildren().addAll(polyLine3D,s1);

        primaryStage.setTitle("F(X)yz ScatterPlotTest");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public class Wer {

        public static void main(String[] args) {
            int[] vector = new int[] { 1, 0, 1, 1 };
            int[] resultVector = new int[7];
            int[][] matrix = new int[][] { { 1, 0, 0, 0, 1, 1, 0 },
                    { 0, 1, 0, 0, 0, 1, 1 },
                    { 0, 0, 1, 0, 1, 1, 1 },
                    { 0, 0, 0, 1, 1, 0, 1 } };

            System.out.println("выводим вектор который будем умножать на матрицу: ");
            for (int i = 0; i < vector.length; i++) {
                System.out.print(vector[i]);
            }
            System.out.println();
            System.out.println("выводим матрицу: ");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }

            for (int j = 0; j < 7; j++) {
                for (int i = 0; i < 4; i++) {
                    resultVector[j] += matrix[i][j] * vector[i];
                }
            }
            System.out.println(
                    "выводим результатирующий вектор который получился в результате перемножения вектора на матрицу");
            for (int i = 0; i < resultVector.length; i++) {
                System.out.print(resultVector[i]);
            }

        }

    }
}
