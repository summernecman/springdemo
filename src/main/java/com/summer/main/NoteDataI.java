package com.summer.main;

import com.summer.main.bean.NoteBean;

/**
 * Created by SWSD on 2017-07-28.
 */
public interface NoteDataI {

    public String getNoteList(int objectId);

    public String addNoteBook(NoteBean bean);

    public String addNote(NoteBean bean);
}
