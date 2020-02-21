package com.demo.bussines;

import com.demo.canonic.Studie;
import com.demo.canonic.Studies;

public interface IStudieService {
    Studie createStudie(Studie studie);
	Studies listStudie(int pagina);
    void deleteStudie(Long idStudie);
    Studie updateStudie(Studie studie);
    Studie getStudie(Long idStudie);
}
