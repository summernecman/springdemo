package com.summer.main;

import com.summer.main.bean.NoteOrBookBean;

/**
 * Created by SWSD on 2017-07-28.
 */
public interface NoteDataI {

    public String getNoteList(int objectId);

    public String addNoteBook(NoteOrBookBean bean);

    public String addNote(NoteOrBookBean bean);

    public String updateData(NoteOrBookBean bean);
}
