import com.joptimizer.exception.JOptimizerException;
import com.joptimizer.functions.ConvexMultivariateRealFunction;
import com.joptimizer.functions.LinearMultivariateRealFunction;
import com.joptimizer.optimizers.JOptimizer;
import com.joptimizer.optimizers.OptimizationRequest;

public class Main {

    public static void main(String[] args) throws JOptimizerException {

        //min(0.3x1 + 0.2x2)
        LinearMultivariateRealFunction objectiveFunction = new LinearMultivariateRealFunction(new double[] {0.3,0.2},0);

        ConvexMultivariateRealFunction[] inequalities = new ConvexMultivariateRealFunction[4];

        //x1>=0
        inequalities[0]= new LinearMultivariateRealFunction(new double[]{-1.0, 0.00}, 0.0);
        //x2>=0
        inequalities[1]= new LinearMultivariateRealFunction(new double[]{-1.0, 0.00}, 0.0);
        // 7x1+3x2 >= 2100
        inequalities[2] = new LinearMultivariateRealFunction(new double[]{-7.0, -3.00}, 2100.0);
        // 2x2 >= 1200
        inequalities[3] = new LinearMultivariateRealFunction(new double[]{0.0, -2.00}, 1200.0);


        OptimizationRequest or = new OptimizationRequest();
        or.setF0(objectiveFunction);
        or.setFi(inequalities);
        or.setToleranceFeas(1.E-9);
        or.setTolerance(1.E-9);

        //optimization
        JOptimizer opt = new JOptimizer();
        opt.setOptimizationRequest(or);
        opt.optimize();

        double[] sol = opt.getOptimizationResponse().getSolution();

        System.out.println( "x" + (1) + ": " + sol[0] + "\tx" + (2) + ": " + sol[1] );
        System.out.println("Y" + ":" + (0.3 * sol[0] + 0.2 *sol[1]));
    }

}
