package hq.cuong.upgradenote.viewholders;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.upgradenote.R;
import hq.cuong.upgradenote.models.Note;
import hq.cuong.upgradenote.networks.jsonmodels.LabNote;

/**
 * Created by Cuong on 12/16/2016.
 */

public class NoteViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.tv_title_item)
    TextView tvTitle;

    @BindView(R.id.tv_content_item)
    TextView tvContent;

    @BindView(R.id.ll_container)
    LinearLayout llContainer;

    public NoteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(LabNote note) {
        tvTitle.setText(note.getTitle());
        tvContent.setText(note.getContent());

        llContainer.setBackgroundColor(Color.parseColor(note.getColor()));
    }
}
