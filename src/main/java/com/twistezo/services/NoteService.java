package com.twistezo.services;

import com.twistezo.models.Note;
import com.twistezo.models.NoteWrapper;

import java.util.List;

/**
 * 
 * @author twistezo
 *
 */

public interface NoteService {
	
	List<Note> findAll();
    void deleteCheckedNote(NoteWrapper noteWrapper);

}
