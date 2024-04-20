package com.example.siteWeb.observator;

import com.example.siteWeb.tabele.Stocuri;
/**
 * Interfața Observator (Obs) definește un mecanism de notificare a actualizărilor de stoc.
 * Implementările acestei interfețe pot fi înregistrate pentru a primi notificări atunci când se actualizează stocurile.
 */
public interface Obs {
    /**
     * Metodă apelată atunci când se actualizează stocurile.
     * @param stocuri Obiectul de stoc actualizat.
     */
    void onStocUpdate(Stocuri stocuri);
}
