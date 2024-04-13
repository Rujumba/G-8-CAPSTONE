package views.messages.services;

import java.util.List;
import models.systemUsers.SystemUser;


public interface MessageSender {
    public void sendGroupMessage(String message, String sender);
    public void notifyGroupMembers(List <SystemUser> groupMessageObservers);
    public void sendMessageToMember(SystemUser messageObserver,String sender,String messageString);
}
