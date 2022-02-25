package studios.willennium.supersudokusolver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static android.view.View.VISIBLE;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab); //This is the button that starts everything
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });

        LinearLayout b111 = findViewById(R.id.b111);
        LinearLayout b112 = findViewById(R.id.b112);
        LinearLayout b113 = findViewById(R.id.b113);
        LinearLayout b121 = findViewById(R.id.b121);
        LinearLayout b122 = findViewById(R.id.b122);
        LinearLayout b123 = findViewById(R.id.b123);
        LinearLayout b131 = findViewById(R.id.b131);
        LinearLayout b132 = findViewById(R.id.b132);
        LinearLayout b133 = findViewById(R.id.b133);
        LinearLayout b211 = findViewById(R.id.b211);
        LinearLayout b212 = findViewById(R.id.b212);
        LinearLayout b213 = findViewById(R.id.b213);
        LinearLayout b221 = findViewById(R.id.b221);
        LinearLayout b222 = findViewById(R.id.b222);
        LinearLayout b223 = findViewById(R.id.b223);
        LinearLayout b231 = findViewById(R.id.b231);
        LinearLayout b232 = findViewById(R.id.b232);
        LinearLayout b233 = findViewById(R.id.b233);
        LinearLayout b311 = findViewById(R.id.b311);
        LinearLayout b312 = findViewById(R.id.b312);
        LinearLayout b313 = findViewById(R.id.b313);
        LinearLayout b321 = findViewById(R.id.b321);
        LinearLayout b322 = findViewById(R.id.b322);
        LinearLayout b323 = findViewById(R.id.b323);
        LinearLayout b331 = findViewById(R.id.b331);
        LinearLayout b332 = findViewById(R.id.b332);
        LinearLayout b333 = findViewById(R.id.b333);

        //create all boxes with ids given by Row + Column (example: 58). Then add to proper layout
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        for (int r = 1; r < 10; r++) {
            for (int c = 1; c < 10; c++) {
                //Create the box. It's id is this: first digit=row, second digit=column
                EditText box = new EditText(this);
                box.setId(10*r + c);
                box.setLayoutParams(lp);
                box.setInputType(InputType.TYPE_CLASS_NUMBER);

                //Add the box to the correct layout
                if (r==1 && c<4) {
                    b111.addView(box);
                }
                if (r==2 && c<4) {
                    b112.addView(box);
                }
                if (r==3 && c<4) {
                    b113.addView(box);
                }
                if (r==4 && c<4) {
                    b211.addView(box);
                }
                if (r==5 && c<4) {
                    b212.addView(box);
                }
                if (r==6 && c<4) {
                    b213.addView(box);
                }
                if (r==7 && c<4) {
                    b311.addView(box);
                }
                if (r==8 && c<4) {
                    b312.addView(box);
                }
                if (r==9 && c<4) {
                    b313.addView(box);
                }
                if (r==1 && c>3 && c<7) {
                    b121.addView(box);
                }
                if (r==2 && c>3 && c<7) {
                    b122.addView(box);
                }
                if (r==3 && c>3 && c<7) {
                    b123.addView(box);
                }
                if (r==4 && c>3 && c<7) {
                    b221.addView(box);
                }
                if (r==5 && c>3 && c<7) {
                    b222.addView(box);
                }
                if (r==6 && c>3 && c<7) {
                    b223.addView(box);
                }
                if (r==7 && c>3 && c<7) {
                    b321.addView(box);
                }
                if (r==8 && c>3 && c<7) {
                    b322.addView(box);
                }
                if (r==9 && c>3 && c<7) {
                    b323.addView(box);
                }
                if (r==1 && c>6) {
                    b131.addView(box);
                }
                if (r==2 && c>6) {
                    b132.addView(box);
                }
                if (r==3 && c>6) {
                    b133.addView(box);
                }
                if (r==4 && c>6) {
                    b231.addView(box);
                }
                if (r==5 && c>6) {
                    b232.addView(box);
                }
                if (r==6 && c>6) {
                    b233.addView(box);
                }
                if (r==7 && c>6) {
                    b331.addView(box);
                }
                if (r==8 && c>6) {
                    b332.addView(box);
                }
                if (r==9 && c>6) {
                    b333.addView(box);
                }
            }
        }

        //Add all markers to list of markers
        for (int n = 0; n < 81; n++) {
            markerList.add(randomMarker());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_restart) {
            Intent restart = new Intent(this, ScrollingActivity.class);
            startActivity(restart);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //The values below will be used for long term things to remember, such as which phase we're on or if we're guessing
    boolean developer = false;
    boolean guessing = false;
    int phase = 0; //0=basic, 1=complex, 2=guess, 3=just restored, and 4=finished
    int whichNumberStart = 0; //This is used on the guess after restoring. I set it to the value of the last guess so the system knows to not make the same guess
    int[] allBoxes; //All boxes' numbers put together--0's for empty
    int[] allMarkers; //All numbers of all markers put together--no 0's for empty
    int[][] allNineCombinations = findAllNineCombinations();
    List<int[]> saveBoardsList = new ArrayList<>(); //This is used to restore the board's boxes back when restoring (an error is found)
    List<int[]> saveMarkersList = new ArrayList<>(); //This is used to restore the marker of the first empty square when restoring (an error is found)
    List<int[]> markerList = new ArrayList<>();

    private void basic() {
        //This method will do a few things:
        //subtract from the markers numbers that they obviously can't be
        //if only one number remains on the marker, make the box that number
        //if only one marker in a group has a number, make the box that number
        TextView status = findViewById(R.id.status);
        status.setText("Using simple logic");
        //If the box is filled in, make the marker that number
        for (int r = 1; r < 10; r++)
            for (int c = 1; c < 10; c++) {
                EditText box = findViewById(10 * r + c);
                if (!box.getText().toString().equals("")) {
                    //The following changes the marker to the way we want it (the same as the box)
                    markerList.set(convert(box.getId(), true), new int[] {Integer.parseInt(box.getText().toString())});
                    if (developer) {
                        //If developer is activated, then we will also change the marker TextView
                        TextView markerT = findViewById(100 + box.getId() + 0); //For some reason it had an error without the + 0
                        markerT.setText("");
                        int[] thisMarker = markerList.get(convert(box.getId(), true));
                        for (int value : thisMarker)
                            markerT.setText(markerT.getText().toString() + "" + value);
                    }
                }
            }
        //For every combination of 9,
        for (int i = 0; i < 27; i++) {
            int[] nineCombination = allNineCombinations[i];
            //subtract from the markers numbers that they obviously can't be
            //if only one number remains on the marker, make the box that number
            //if only one marker in a group has a number in its marker, make the box that number
            List<EditText> boxList = new ArrayList<>();
            boxList.add((EditText) findViewById(nineCombination[0]));
            boxList.add((EditText) findViewById(nineCombination[1]));
            boxList.add((EditText) findViewById(nineCombination[2]));
            boxList.add((EditText) findViewById(nineCombination[3]));
            boxList.add((EditText) findViewById(nineCombination[4]));
            boxList.add((EditText) findViewById(nineCombination[5]));
            boxList.add((EditText) findViewById(nineCombination[6]));
            boxList.add((EditText) findViewById(nineCombination[7]));
            boxList.add((EditText) findViewById(nineCombination[8]));
            List<int[]> markerListFor9 = new ArrayList<>();
            markerListFor9.add(markerList.get(convert(nineCombination[0], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[1], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[2], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[3], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[4], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[5], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[6], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[7], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[8], true)));
            //The following array will be temporarily used to keep track of all numbers represented by the group of 9
            List<Integer> numberList = new ArrayList<>();
            //Go through all 9 boxes
            for (int b = 0; b < 9; b++) {
                EditText box = boxList.get(b);
                String boxS = box.getText().toString();
                //Only add the number if the box isn't empty
                if (!boxS.equals("")) {
                    Integer boxI = Integer.parseInt(boxS);
                    //If the numberList doesn't contain it yet, add the number to the list
                    if (!numberList.contains(boxI))
                        numberList.add(boxI);
                }
            }
            //We now have a list of all numbers represented by the group of nine: numberList
            //Now we remove these numbers from every marker with an empty box (we don't want to change the marker of a filled box). remove only asks for the boxList and numberList, because it can figure out the markers based on the boxes
            remove(boxList, numberList);
            //Now, every number represented by the group has been removed from the marker of every blank box
            //If any marker is only 1 digit long, make that box that number
            for (int m = 0; m < 9; m++) {
                EditText box = boxList.get(m);
                int[] marker = markerListFor9.get(m);
                if (marker.length == 1)
                    box.setText(Integer.toString(marker[0]));
            }
            //Now, if any marker is the only one with a certain number, make the box that number
            for (int n = 1; n < 10; n++) {
                //For the booleans below, each one will be false if it doesn't have n in it
                boolean contains1 = intArrayContains(markerListFor9.get(0), n);
                boolean contains2 = intArrayContains(markerListFor9.get(1), n);
                boolean contains3 = intArrayContains(markerListFor9.get(2), n);
                boolean contains4 = intArrayContains(markerListFor9.get(3), n);
                boolean contains5 = intArrayContains(markerListFor9.get(4), n);
                boolean contains6 = intArrayContains(markerListFor9.get(5), n);
                boolean contains7 = intArrayContains(markerListFor9.get(6), n);
                boolean contains8 = intArrayContains(markerListFor9.get(7), n);
                boolean contains9 = intArrayContains(markerListFor9.get(8), n);
                //Following is a complex way to check if exactly one of the contain booleans is true
                if (((contains1 ? 1: 0) + (contains2 ? 1: 0) + (contains3 ? 1: 0) + (contains4 ? 1: 0) + (contains5 ? 1: 0) + (contains6 ? 1: 0) + (contains7 ? 1: 0) + (contains8 ? 1: 0) + (contains9 ? 1: 0)) == 1)
                    if (contains1)
                        boxList.get(0).setText(Integer.toString(n));
                    else if (contains2)
                        boxList.get(1).setText(Integer.toString(n));
                    else if (contains3)
                        boxList.get(2).setText(Integer.toString(n));
                    else if (contains4)
                        boxList.get(3).setText(Integer.toString(n));
                    else if (contains5)
                        boxList.get(4).setText(Integer.toString(n));
                    else if (contains6)
                        boxList.get(5).setText(Integer.toString(n));
                    else if (contains7)
                        boxList.get(6).setText(Integer.toString(n));
                    else if (contains8)
                        boxList.get(7).setText(Integer.toString(n));
                    else if (contains9)
                        boxList.get(8).setText(Integer.toString(n));
            }
        }
    }
    private void check() {
        //This checks to see if any group of 9 has multiple occurrences of a number or if any markers are empty. If either of these things happened, we need to restore (or it's impossible)

        //Check all markers
        for (int n = 0; n < 81; n++) {
            //If the marker length is 0, then it's impossible because it's empty
            int[] marker = markerList.get(n);
            if (marker.length == 0)
                if (guessing)
                    //If we're on the guessing part, then impossibilities are a normal thing, and we just restore.
                    restore();
                else {
                    //If we're not on guessing, we need to stop and alert the user that there was a problem.
                    CheckBox pause = findViewById(R.id.pause);
                    pause.setChecked(true);
                    TextView status = findViewById(R.id.status);
                    status.setText("This board is impossible.");
                }
        }


        //For every combination of 9,
        for (int i = 0; i < 27; i++) {
            int[] nineCombination = allNineCombinations[i];
            //This checks to see if any of the boxes have the same value
            //If any 2 of them have the same value, we need to restore because that is impossible
            //Unless they are both "". That is why I put the ! box1S.equals(""), etc.
            EditText box1 = findViewById(nineCombination[0]);
            EditText box2 = findViewById(nineCombination[1]);
            EditText box3 = findViewById(nineCombination[2]);
            EditText box4 = findViewById(nineCombination[3]);
            EditText box5 = findViewById(nineCombination[4]);
            EditText box6 = findViewById(nineCombination[5]);
            EditText box7 = findViewById(nineCombination[6]);
            EditText box8 = findViewById(nineCombination[7]);
            EditText box9 = findViewById(nineCombination[8]);
            String box1S = box1.getText().toString();
            String box2S = box2.getText().toString();
            String box3S = box3.getText().toString();
            String box4S = box4.getText().toString();
            String box5S = box5.getText().toString();
            String box6S = box6.getText().toString();
            String box7S = box7.getText().toString();
            String box8S = box8.getText().toString();
            String box9S = box9.getText().toString();
            boolean impossible = false;
            if (!box1S.equals("") && (box1S.equals(box2S) || box1S.equals(box3S) || box1S.equals(box4S) || box1S.equals(box5S) || box1S.equals(box6S) || box1S.equals(box7S) || box1S.equals(box8S) || box1S.equals(box9S)))
                impossible = true;
            if (!box2S.equals("") && (box2S.equals(box3S) || box2S.equals(box4S) || box2S.equals(box5S) || box2S.equals(box6S) || box2S.equals(box7S) || box2S.equals(box8S) || box2S.equals(box9S)))
                impossible = true;
            if (!box3S.equals("") && (box3S.equals(box4S) || box3S.equals(box5S) || box3S.equals(box6S) || box3S.equals(box7S) || box3S.equals(box8S) || box3S.equals(box9S)))
                impossible = true;
            if (!box4S.equals("") && (box4S.equals(box5S) || box4S.equals(box6S) || box4S.equals(box7S) || box4S.equals(box8S) || box4S.equals(box9S)))
                impossible = true;
            if (!box5S.equals("") && (box5S.equals(box6S) || box5S.equals(box7S) || box5S.equals(box8S) || box5S.equals(box9S)))
                impossible = true;
            if (!box6S.equals("") && (box6S.equals(box7S) || box6S.equals(box8S) || box6S.equals(box9S)))
                impossible = true;
            if (!box7S.equals("") && (box7S.equals(box8S) || box7S.equals(box9S)))
                impossible = true;
            if (!box8S.equals("") && (box8S.equals(box9S)))
                impossible = true;
            if (impossible)
                //If it's impossible, we either need to restore or alert user
                if (guessing)
                    //If we're on the guessing part, then impossibilities are a normal thing, and we just restore.
                    restore();
                else {
                    //If we're not on guessing, we need to stop and alert the user that there was a problem.
                    CheckBox pause = findViewById(R.id.pause);
                    pause.setChecked(true);
                    TextView status = findViewById(R.id.status);
                    status.setText("This board is impossible.");
                }
        }
    }
    private void complex() {
        //This method uses logic like this: if two markers in a group are identical and have length 2, then no other markers in the group can have the numbers in those markers
        //It plugs all groups into complexPlugIn, just like basic does into basicPlugIn
        TextView status = findViewById(R.id.status);
        status.setText("Using more complex logic");
        //For every combination of 9,
        for (int i = 0; i < 27; i++) {
            //If x many markers in a group are identical and have length x, then remove their numbers from every marker in the group. It's only worth it to go to length like 2 or 3
            int[] nineCombination = allNineCombinations[i];
            List<EditText> boxList = new ArrayList<>();
            boxList.add((EditText) findViewById(nineCombination[0]));
            boxList.add((EditText) findViewById(nineCombination[1]));
            boxList.add((EditText) findViewById(nineCombination[2]));
            boxList.add((EditText) findViewById(nineCombination[3]));
            boxList.add((EditText) findViewById(nineCombination[4]));
            boxList.add((EditText) findViewById(nineCombination[5]));
            boxList.add((EditText) findViewById(nineCombination[6]));
            boxList.add((EditText) findViewById(nineCombination[7]));
            boxList.add((EditText) findViewById(nineCombination[8]));
            List<int[]> markerListFor9 = new ArrayList<>();
            markerListFor9.add(markerList.get(convert(nineCombination[0], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[1], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[2], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[3], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[4], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[5], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[6], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[7], true)));
            markerListFor9.add(markerList.get(convert(nineCombination[8], true)));

            //This is sort of like math permutations--all 9 can start, then there's 8 left, and so on
            //All the one-letter variables represent a box--they are ints that correspond to a box
            for (int a=0; a<9; a++) {
                int[] newMarker1 = markerListFor9.get(a);
                //This has gone through each box/marker
                //We now go through all 9 again, but make sure that we don't continue if it's the same box as before, because we need to compare 2 different boxes/markers
                for (int b=0; b<9; b++)
                    if (! (b==a)) {
                        int[] newMarker2 = markerListFor9.get(b);
                        //Now test these 2 to see if they are identical and of length 2
                        if (newMarker1.length == 2 && newMarker2.length == 2 && newMarker1[0] == newMarker2[0] && newMarker1[1] == newMarker2[1]) {
                            //In this part, we have to remove every number inside of these 2 markers from every other marker. The tough part is making a list of all other markers besides these.
                            List<EditText> boxListForRemoval = new ArrayList<>();
                            //Add any box and that isn't one of the 2
                            for (int r = 0; r<9; r++)
                                //unless r is one of the 2
                                if (! (r==a || r==b))
                                    //add the box to the list--we don't need to add the marker, because remove knows how to find the marker given the box
                                    boxListForRemoval.add(boxList.get(r));
                            //Now remove the 2 numbers from the rest
                            remove(boxListForRemoval, newMarker1);
                        }
                        //Now get the 3rd marker, but it can't be either of the first 2
                        for (int c = 0; c < 9; c++)
                            if (! (c==a || c==b)) {
                                int[] newMarker3 = markerListFor9.get(c);
                                //Now test these 3 to see if they are identical and of length 3
                                if ((newMarker1.length == 3 && newMarker2.length == 3 && newMarker3.length == 3) && (newMarker1[0] == newMarker2[0] && newMarker1[0] == newMarker3[0]) && (newMarker1[1] == newMarker2[1] && newMarker1[1] == newMarker3[1]) && (newMarker1[2] == newMarker2[2] && newMarker1[2] == newMarker3[2])) {
                                    //This is just like before, but with 3 markers. We make a list of every marker that isn't one of these 3
                                    ArrayList<EditText> boxListForRemoval = new ArrayList<>();
                                    //Add any box that isn't one of the 3--remove will find its marker
                                    for (int r = 0; r<9; r++)
                                        //unless r is one of the 3
                                        if (r!=a && r!=b && r!=c)
                                            //add the box to the list
                                            boxListForRemoval.add(boxList.get(r));
                                    //Now remove the 3 numbers from the rest
                                    remove(boxListForRemoval, newMarker1);
                                }
                            }
                    }
            }
        }
    }
    private void developer() {
        //This is the thing it does when I enter the code in the middle box to do special stuff
        developer = true;
        LinearLayout invisible = findViewById(R.id.invisible);
        invisible.setVisibility(View.VISIBLE);
        CheckBox pause = findViewById(R.id.pause);
        pause.setVisibility(VISIBLE);
        //Make the phase TextView show the phase
        TextView phaseT = findViewById(R.id.phase);
        phaseT.setText(Integer.toString(phase));
        //Add TextViews to show the markers so you can see what's happening
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        for (int r = 1; r < 10; r++) {
            for (int c = 1; c < 10; c++) {
                //Create the marker and set its text. It's id is like the box, but there's a 1 before it
                TextView markerT = new TextView(this);
                markerT.setId(100 + 10*r + c);
                markerT.setLayoutParams(lp);
                int[] marker = markerList.get(convert(10*r + c, true));
                markerT.setText("");
                for (int value : marker)
                    markerT.setText(markerT.getText().toString() + "" + Integer.toString(value));

                //Add the marker to the marker layout
                LinearLayout markerLayout = findViewById(R.id.markers);
                markerLayout.addView(markerT);
            }
            //After every nine markers, I'm creating this space to make it more organized
            TextView space = new TextView(this);
            space.setLayoutParams(lp);

            //Add the space to the marker layout
            LinearLayout markerLayout = findViewById(R.id.markers);
            markerLayout.addView(space);
        }
        Toast.makeText(this, "You have unlocked special access!", Toast.LENGTH_SHORT).show();
    }
    private void go() {
        //This is the main part of the app
        //It starts at the basic phase, and then it does complex logic once basic has done all it can.
        //If complex does something, it goes back to basic and restarts the cycle.
        //Once basic and complex have done everything they can, it makes a guess and restarts the cycle at basic.
        //Once a guess fails, it restores the guess, undoing it and moving on to the next guess
        if (developer) {
            TextView count = findViewById(R.id.count);
            //I'm having a textview counting things so I can keep up with how many times it goes through
            count.setText(Integer.toString(1 + Integer.parseInt(count.getText().toString())));
        }
        TextView status = findViewById(R.id.status);
        //We will set allBoxes and allMarkers to their respective values now and compare at the end
        allBoxes = fullBoardCreate(true);
        allMarkers = fullBoardCreate(false);
        if (phase != 4) { //If we're not finished
            if (phase == 0) {
                basic();
            } else {
                if (phase == 1) {
                    complex();
                } else {
                    if (phase == 2) {
                        guess();
                    }
                }
            }
        }
        //We will now do check(), which checks to see if there are multiple boxes with the same value in a group of 9
        //If so, the method either restores (if guessing) or alerts the user and stops (if not)
        check();
        //Either say that we're done, move to next step, or go back to 1st step
        int[] newAllBoxes = fullBoardCreate(true);
        boolean finished = true;
        for (int i = 0; i < newAllBoxes.length; i++)
            if (newAllBoxes[i] == 0)
                    finished = false;
        if (finished) {
            status.setText("Finished");
            phase = 4;
            CheckBox pause = findViewById(R.id.pause);
            pause.setChecked(true);
        } else {
            //If we have just restored, the system changes phase to 3, so we change the phase to guess here
            if (phase == 3)
                phase = 2;
            //Otherwise, if we have just guessed, change the phase to basic because it starts from beginning logic
            else if (phase == 2)
                phase = 0;
            //Otherwise, if nothing has changed, go to next step
            else if (Arrays.equals(allBoxes, newAllBoxes) && Arrays.equals(allMarkers, fullBoardCreate(false))) {
                if (phase == 1)
                    //Here, also change guessing to true because we are moving to guessing phase
                    guessing = true;
                phase++;
            //Otherwise (something has changed), go back to basic
            } else
                phase = 0;
        }
        if (developer) {
            TextView phaseT = findViewById(R.id.phase);
            phaseT.setText(Integer.toString(phase));
        }
    }
    private void guess() {
        //This method is in charge of making a guess and saving the necessary information for restoration.
        //It finds the first empty square, fills it in with the first value of its marker, then saves the way the board looked before and the box's marker
        //After restoration (the next time through the cycle), this method will be called. The restore function sets whichNumberStart to the last guess, so this method knows to guess the next number in that box's marker
        //If that guess was the last one, then we restore again, because that means we have tried the last option on that box and it failed

        TextView status = findViewById(R.id.status);
        //Find the index of the first empty box in the list of all boxes
        int[] fullBoard = fullBoardCreate(true);
        int firstEmptyBoxIndex = indexOfArray(fullBoard, 0);
        //Now find the box based on this index
        TextView firstEmptyBox = findViewById(convert(firstEmptyBoxIndex, false));
        //Now get its marker
        int[] firstEmptyBoxMarker = markerList.get(firstEmptyBoxIndex);
        status.setText("Making a guess");
        //We will go ahead and remember what the board looks like before we change anything--this is for saving
        int[] allBoxesTemporary = fullBoardCreate(true);

        //Look at whichNumberStart. WhichNumberStart is used if we have just restored to tell the system what the last guess was. If it is empty, then our guess will be index 0 of the marker (the first value) because we have not guessed yet.
        Integer newIndex;
        if (whichNumberStart == 0)
            newIndex = 0;
        else
            //If not empty, then the index we want is one after the previous index. Basically, we move on to the next guess after the previous one failed
            newIndex = 1 + indexOfArray(firstEmptyBoxMarker, whichNumberStart);

        //If the new Index is too high (newIndex = length), then restore, because that means we have tried the last option on that box and it failed
        if (newIndex == firstEmptyBoxMarker.length)
            restore();
        else {
            //Otherwise, set the box to the index we want
            firstEmptyBox.setText(Integer.toString(firstEmptyBoxMarker[newIndex]));
            //Save the fullBoard(box) + the marker of the box we changed. This is all the information needed to restore
            saveBoardsList.add(allBoxesTemporary);
            saveMarkersList.add(firstEmptyBoxMarker);
            //Reset whichNumberStart if we don't have to restore--If we restore, then whichNumberStart needs to be a number
            whichNumberStart = 0;
        }

        //If we're finished
        if (indexOfArray(fullBoardCreate(true), 0) == -1) {
            status.setText("Finished");
            phase = 4;
        }
    }
    private void remove(List<EditText> boxList, int[] numberArray) {
        //This method removes every number in numberList from the marker corresponding to every bax in boxList
        //For every box/marker
        for (int b = 0; b < boxList.size(); b++) {
            EditText box = boxList.get(b);
            //Find the corresponding marker
            int[] marker = markerList.get(convert(box.getId(), true));
            String boxS = box.getText().toString();
            //We don't want to change the marker of a filled box
            if (boxS.equals("")) {
                //Now we will go through every number in the numberList
                for (int n = 0; n < numberArray.length; n++) {
                    int number = numberArray[n];
                    if (intArrayContains(marker, number)) {
                        //Create a new int[] to replace marker
                        int[] newMarker = new int[marker.length - 1];
                        int index = 0;
                        for (int i = 0; i < marker.length; i++)
                            if (marker[i] != number) {
                                newMarker[index] = marker[i];
                                index++;
                            }
                        markerList.remove(marker);
                        markerList.add(convert(box.getId(), true), newMarker);
                        marker = newMarker;
                        if (developer) {
                            //If developer is activated, then we will also change the marker TextView
                            TextView markerT = findViewById(100 + box.getId() + 0); //For some reason it had an error without the + 0
                            markerT.setText("");
                            for (int i = 0; i < marker.length; i++)
                                markerT.setText(markerT.getText().toString() + marker[i]);
                        }
                    }
                }
            }
        }
    }
    private void remove(List<EditText> boxList, List<Integer> numberList) {
        int[] numberArray = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++)
            numberArray[i] = numberList.get(i);
        remove(boxList, numberArray);
    }
    private void restore() {
        //When there is an error found (we made an incorrect guess), this method will be activated
            //It basically undoes the last guess and tells the system what the last guess was--this way, it knows to guess the next value in the marker the next time

        TextView status = findViewById(R.id.status);
        status.setText("A guess was incorrect, so we are backtracking");
        //Find the last save value because that is the one we use
        int[] saveBoard = saveBoardsList.get(saveBoardsList.size() - 1);
        int[] saveMarker = saveMarkersList.get(saveMarkersList.size() - 1);
        //Now remove the last save because it is no longer needed
        saveBoardsList.remove(saveBoardsList.size() - 1);
        saveMarkersList.remove(saveMarkersList.size() - 1);

        //Reset all the markers
        for (int n = 0; n < 81; n++)
            markerList.set(n, randomMarker());

        //The following is the index of the first empty box from our save (the one we changed last time)
        int importantBoxIndex = indexOfArray(saveBoard, 0);
        //Make whichNumberStart the value of the box that matters--we use convert to get from the index (0-80) to a row + column format
        TextView importantBox = findViewById(convert(importantBoxIndex, false));
        whichNumberStart = Integer.parseInt(importantBox.getText().toString()); //Keep in mind that importantBox hasn't been changed or cleared yet--it's still the last guess
        //Change the marker that matters (the old firstEmptyBox) back to what it was before. The old marker is at the end of the save value (starts at index 81)
        markerList.set(importantBoxIndex, saveMarker);

        //Now reset the board to what it was before--including changing the importantBox to blank--the system will make a new guess next time
        for (int n = 0; n < 81; n++) {
            //Find the proper box
            TextView box = findViewById(convert(n, false));
            //Set the box to its proper value based off of the save value. But if the value is 0, that means ""
            int newValue = saveBoard[n];
            if (newValue == 0)
                box.setText("");
            else
                box.setText(Integer.toString(newValue));
        }

        //Change the phase to just restored--restore happens in the middle of go()
            //We can't make the phase 2, because then the system will go back to basic at the end of go(). We have to tell it that we just restored, so that it will change to phase 2
        phase = 3;
    }
    private void start() {
        //I have a little easter egg where you can type my birthday into the middle square to unlock special stuff
        EditText developerBox = findViewById(55 + 0); //I had to put + 0 to avoid an error
        if (developerBox.getText().toString().equals("09262000"))
            developer();
        else {
            //This is the normal thing
            TextView status = findViewById(R.id.status);
            status.setText("We have begun");
            new CountDownTimer(10000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        //Go unless pause is checked
                        CheckBox pause = findViewById(R.id.pause);
                        if (!pause.isChecked())
                            go();
                    }

                    public void onFinish() {
                        //Restart the timer unless finished
                        if (phase != 4)
                            start();
                    }
            }.start();
        }
    }

    private boolean intArrayContains(int[] array, int number) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == number)
                return true;
        return false;
    }

    private int convert(Integer original, boolean rowColumnToNumber) {
        //This method converts between a 0-80 code and my numbering system (row and column)

        if (rowColumnToNumber) {
            //We need to change the row + column format to a 0-80 format
            Integer row = original / 10; //This gives the first digit
            Integer column = original % 10; //This gives the second digit
            return 9*(row - 1) + column - 1;
        } else {
            //We need to change the 0-80 format to a row + column format
            Integer newRow = original / 9 + 1;
            Integer newColumn = original % 9 + 1;
            return 10*newRow + newColumn;
        }
    }
    private int indexOfArray(int[] intArray, int number) {
        int toReturn = -1;
        for (int i = 0; i < intArray.length; i++)
            if (intArray[i] == number) {
                toReturn = i;
                break;
            }
        return toReturn;
    }

    private int[] fullBoardCreate(boolean boxes) {
        //This method creates a combination of all boxes
        int[] toReturn;
        if (boxes) {
            toReturn = new int[81];
            for (int r = 1; r < 10; r++)
                for (int c = 1; c < 10; c++) {
                    //for every box, either add the box value
                    EditText box = findViewById(10 * r + c);
                    if (box.getText().toString().equals(""))
                        toReturn[convert(10 * r + c, true)] = 0;
                    else
                        toReturn[convert(10 * r + c, true)] = Integer.parseInt(box.getText().toString());
                }
        } else {
            int[] toReturnTemp = new int[729];
            int index = 0;
            for (int i = 0; i < markerList.size(); i++)
                for (int j = 0; j < markerList.get(i).length; j++) {
                    toReturnTemp[index] = markerList.get(i)[j];
                    index++;
                }
            toReturn = new int[index];
            for (int i = 0; i < index; i++)
                toReturn[i] = toReturnTemp[i];
        }
        return toReturn;
    }
    private int[] randomMarker() {
        //Returns 1 through 9 in a random order
        int[] toReturn = new int[9];
        Random random = new Random();

        int index = 0;
        while (index < 9) {
            int nextInt = 1 + random.nextInt(9);
            boolean repeat = false;
            for (int i = 0; i < index; i++)
                if (toReturn[i] == nextInt)
                    repeat = true;
            if (!repeat) {
                toReturn[index] = nextInt;
                index++;
            }
        }

        return toReturn;
    }
    private int[][] findAllNineCombinations() {
        int[][] toReturn = new int[27][9];
        //Rows
        for (int row = 1; row < 10; row++)
            toReturn[row - 1] = new int[] {10*row + 1, 10*row + 2, 10*row + 3, 10*row + 4, 10*row + 5, 10*row + 6, 10*row + 7, 10*row + 8, 10*row + 9};
        //Columns
        for (int column = 1; column < 10; column++)
            toReturn[column + 8] = new int[] {10 + column, 20 + column, 30 + column, 40 + column, 50 + column, 60 + column, 70 + column, 80 + column, 90 + column};
        //Squares
        for (int square = 1; square < 10; square++) {
            if (square == 1 || square == 4 || square == 7)
                toReturn[square + 17] = new int[] {10*square + 1, 10*square + 2, 10*square + 3, 10*square + 11, 10*square + 12, 10*square + 13, 10*square + 21, 10*square + 22, 10*square + 23};
            if (square == 2 || square == 5 || square == 8)
                toReturn[square + 17] = new int[] {10*square - 6, 10*square - 5, 10*square - 4, 10*square + 4, 10*square + 5, 10*square + 6, 10*square + 14, 10*square + 15, 10*square + 16};
            if (square == 3 || square == 6 || square == 9)
                toReturn[square + 17] = new int[] {10*square - 13, 10*square - 12, 10*square - 11, 10*square - 3, 10*square - 2, 10*square - 1, 10*square + 7, 10*square + 8, 10*square + 9};
        }
        return toReturn;
    }
}
