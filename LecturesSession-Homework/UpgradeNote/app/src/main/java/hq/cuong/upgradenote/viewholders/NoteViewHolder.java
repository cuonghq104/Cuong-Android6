package hq.cuong.upgradenote.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hq.cuong.upgradenote.R;
import hq.cuong.upgradenote.models.Note;

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

    public void bind(Note note) {
        tvTitle.setText(note.getTitle());
        tvContent.setText(note.getContent());
        int color = note.getColor();
        switch (color) {
            case 0:
                llContainer.setBackgroundResource(R.color.red);
                break;
            case 1:
                llContainer.setBackgroundResource(R.color.green);
                break;
            case 2:
                llContainer.setBackgroundResource(R.color.blue);
                break;
            case 3:
                llContainer.setBackgroundResource(R.color.yellow);
                break;
            case 4:
                llContainer.setBackgroundResource(R.color.gray);
                break;
            case 5:
                llContainer.setBackgroundResource(R.color.purple);
                break;
        }
    }
}
