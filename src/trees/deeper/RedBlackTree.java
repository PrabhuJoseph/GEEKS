package trees.deeper;


// https://www.youtube.com/watch?v=UaLIHuR1t8Q

public class RedBlackTree {

    /*
    RULES for RedBlackTree (which is a Self Balanced Binary Search Tree like AVL)
    but with less number of rotations

    1. Root has to be black
    2. No Red Parent-Child RelationShip
    3. Number of Black Nodes on all path has to be same.
     */

    /*

    INSERTION RULES:

    1. If first node - add as black
    2. Else add as red
       * If it add Red - Red Parent Child Relationship
           Then, check parent sibling - if that is also red - change both of them into black
                 if parent is root and black - leave it with black
                 if parent is not root and black - turn into red
           Else if parent sibling does not exist / black - do rotation
                Left Left -> Right Rotation
                Left Right -> Left and Right Rotation
                Right RIght -> Left Rotation
                Right Left -> Right and Left Rotation

     */


}
