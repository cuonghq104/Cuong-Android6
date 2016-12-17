package hq.cuong.upgradenote.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hq.cuong.upgradenote.R;
import hq.cuong.upgradenote.models.Note;
import hq.cuong.upgradenote.viewholders.NoteViewHolder;

/**
 * Created by Cuong on 12/16/2016.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.note_item, parent, false);

        NoteViewHolder noteViewHolder = new NoteViewHolder(view);

        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note note = Note.getNotes().get(position);

        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return Note.getNotes().size();
    }
}
