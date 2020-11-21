package ru.timsv.fieldcoordinator.model.response;

import java.util.List;

public class ResponseData {
    public League league;
    public Map map;
    public List<BattlegroundParticipant> battlegroundParticipants;
    public CurrentPlayerParticipant currentPlayerParticipant;
    public int currentParticipantId;
    public int time;

    public int endsAt;
    public String __class__;

    public League getLeague() {
        return league;
    }

    public Map getMap() {
        return map;
    }

    public List<BattlegroundParticipant> getBattlegroundParticipants() {
        return battlegroundParticipants;
    }

    public CurrentPlayerParticipant getCurrentPlayerParticipant() {
        return currentPlayerParticipant;
    }

    public int getEndsAt() {
        return endsAt;
    }

}
