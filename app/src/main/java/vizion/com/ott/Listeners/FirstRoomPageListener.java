package vizion.com.ott.Listeners;

import android.app.Activity;

import com.github.nkzawa.emitter.Emitter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import vizion.com.ott.Adapters.ListRoomAdapter;
import vizion.com.ott.Models.MyRoom;
import vizion.com.ott.Models.Room;

/**
 * Created by dthongvl on 11/13/16.
 */
public class FirstRoomPageListener implements Emitter.Listener{
    private Activity activity;
    private static FirstRoomPageListener ourInstance = new FirstRoomPageListener();

    public static FirstRoomPageListener getInstance(Activity activity) {
        ourInstance.activity = activity;
        return ourInstance;
    }

    private FirstRoomPageListener() {
    }

    @Override
    public void call(final Object... args) {
        ourInstance.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                JSONObject data = (JSONObject) args[0];
                try {
                    MyRoom.getInstance().setTotalPage(data.getInt("total_page"));
                    JSONArray arrRooms = data.getJSONArray("rooms");
                    ArrayList<Room> firstPage = new ArrayList<Room>();
                    for(int roomIndex =0; roomIndex < arrRooms.length();roomIndex++){
                        firstPage.add(new Room(arrRooms.getJSONObject(roomIndex)));
                    }

                    if(MyRoom.getInstance().getListRooms().size()>0){
                        MyRoom.getInstance().setUpdate(true);
                        MyRoom.getInstance().getRoomPage(MyRoom.getInstance().getCurrentPage());
                    }
                    MyRoom.getInstance().setFirstPageRooms(firstPage);

                    }
                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
