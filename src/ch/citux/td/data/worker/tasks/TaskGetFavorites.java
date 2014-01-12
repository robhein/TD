package ch.citux.td.data.worker.tasks;

import ch.citux.td.R;
import ch.citux.td.data.model.Favorites;
import ch.citux.td.data.service.TDServiceImpl;
import ch.citux.td.data.worker.TDCallback;

public class TaskGetFavorites extends TDTask<String, Favorites> {


    public TaskGetFavorites(TDCallback<Favorites> callback) {
        super(callback);
    }

    @Override
    protected Favorites doInBackground(String... params) {
        if (params.length == 1) {
            return TDServiceImpl.getInstance().getFavorites(params[0]);
        }
        Favorites favorites = new Favorites();
        favorites.setErrorResId(R.string.error_unexpected);
        return favorites;
    }
}