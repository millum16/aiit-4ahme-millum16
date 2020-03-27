/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k23.k23_2.k23_2_2;

/**
 *
 * @author lukasmilhalm
 */
public class Listing2302 {

    public static void main(String[] args) {
        MyThread2302 t = new MyThread2302();
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //nichts
        }
        t.stop();
    }

}
