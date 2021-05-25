package javacamp.hrms.core.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import javacamp.hrms.core.abstracts.MernisCheckService;
import javacamp.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisCheckAdapter implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
		boolean result=false;
		try {
			result=client.TCKimlikNoDogrula(
						Long.valueOf(jobSeeker.getIdentification_number()), 
						jobSeeker.getFirst_name(), 
						jobSeeker.getLast_name(), 
						jobSeeker.getBirth_year());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

}
