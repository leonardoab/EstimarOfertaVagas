package br.ufjf.coordenacao.OfertaVagas.report;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import br.ufjf.coordenacao.OfertaVagas.estimate.Estimative;
import br.ufjf.coordenacao.OfertaVagas.estimate.EstimativesResult;

public class CSVReport extends EstimativeReport {

	public CSVReport(PrintStream out) {
		super(out);
	}
	
	public void generate(EstimativesResult result) throws IOException {
		ArrayList<Estimative> estimatives = result.getEstimatives();
		 
		out.println("Class id; # has all prerequisites; # can complete all prerequisites; # enrolled; " +
				"# has all prerequisites and is expected to enroll; # expected to complete all reprequisites;" +
				"# expected to not complete the class; expected to enroll in the next semester");
		for (Estimative estimative : estimatives) {
			out.println(estimative.getClassId() + ";" 
					+ estimative.getQtdHasAllPrereq() + ";" 
					+ estimative.getQtdCanHaveAllPreq() + ";" 
					+ estimative.getQtdEnrolled() + ";"
					+ estimative.getQtdHasAllPrereqWeighted() + ";"
					+ estimative.getQtdCanHaveAllPreqWeighted() + ";"
					+ estimative.getQtdEnrolledWeighted() + ";"
					+estimative.getQtdTotal());
		}
	}
	
}
