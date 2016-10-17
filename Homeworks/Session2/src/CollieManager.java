//import controllers.ControllerManager;
//import controllers.EnemyControllerManager;
//import controllers.PlaneController;
//
///**
// * Created by Cuong on 10/13/2016.
// */
//public class CollieManager {
//
//    private ControllerManager planeControlManager;
//
//    private EnemyControllerManager enemyControlManager;
//
//    public CollieManager(ControllerManager planeControlManager, EnemyControllerManager enemyControlManager) {
//        this.planeControlManager = planeControlManager;
//        this.enemyControlManager = enemyControlManager;
//    }
//
//    public void run() {
//        for (int i = 0; i < planeControlManager.getSingleControllers().size(); i++) {
//
//            PlaneController planeController = (PlaneController) planeControlManager.getSingleControllers().get(i);
//
//            for (int j = 0; j < planeController.getBulletControllerManager().getSingleControllers().size(); j++) {
//
////                if (planeController.getBulletControllerManager().getSingleControllers().get(j).getGameObject().getY() < 0) {
////                    planeController.getBulletControllerManager().getSingleControllers().remove(j);
////                }
//
//                for (int k = 0; k < enemyControlManager.getEnemyControllers().size(); k++) {
//
//                    if (enemyControlManager.getEnemyControllers().get(k).getGameObject().getBottom()
//                            >= planeController.getBulletControllerManager().getSingleControllers().get(j).getGameObject().getY()
//
//                            && enemyControlManager.getEnemyControllers().get(k).getGameObject().getX()
//                            < planeController.getBulletControllerManager().getSingleControllers().get(j).getGameObject().getX()
//
//                            && enemyControlManager.getEnemyControllers().get(k).getGameObject().getRight()
//                            > planeController.getBulletControllerManager().getSingleControllers().get(j).getGameObject().getX()) {
//                        System.out.println("Collied");
//                        enemyControlManager.getEnemyControllers().remove(k);
//                        planeController.getBulletControllerManager().getSingleControllers().remove(j);
//                        return;
//                    }
//                }
//            }
//        }
//    }
//
//}
