package com.demo.facade.employee.v0;

import com.demo.canonic.Studie;
import com.demo.canonic.Studies;

public interface IStudieControllerV0 {
	Studie createStudie(Studie studie);
	Studies listStudie();
    void deleteStudie(Long idStudie);
    Studies updateStudie(Studie studie);
    Studie getStudie(Long idStudie);
}
