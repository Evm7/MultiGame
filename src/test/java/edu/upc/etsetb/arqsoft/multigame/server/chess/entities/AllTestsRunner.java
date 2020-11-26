/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.multigame.server.chess.entities;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 *
 * @author estev
 */
public class AllTestsRunner {

    public static void main(String[] args) {
        Result result
                = JUnitCore.runClasses(PiecesTestSuite.class);
        if (result.getFailureCount() != 0) {
            System.out.println("\nThere have been failures. Below follow the details:\n");
            for (Failure failure : result.getFailures()) {
                System.out.println("Test case associated to method: "+ failure);
            }
        } else {
            System.out.println("\nAll the test cases were successful");
        }
    }
}
