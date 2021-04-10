import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class NvtPhybridgeSwitch extends Switches {

    CisdoSwitch uplink1;
    CisdoSwitch uplink2;

    {String defaultConfig = """
            @@@@@ /etc/hostname
            CLEER
            @@@@@ /etc/network/interfaces
            # Configure Loopback
            auto lo
            iface lo inet loopback

            auto mgmt

            iface mgmt inet static
                address  192.168.1.1
                netmask  255.255.255.0
                broadcast  192.168.1.255
            #   gateway 
                    
            auto eth0

            iface eth0 inet static
                address  192.168.100.1
                netmask  255.255.255.0
                broadcast  192.168.100.255
            #   gateway 
             
            @@@@@ /etc/ntpd.conf
            restrict default noquery
            server 129.6.15.28 
            server 132.163.97.1
            server 128.138.140.44
            @@@@@ /etc/stp.conf
            BRPRIO=32768
            PROTO=rstp
            AGE=20
            FDELAY=15
            GBE1COST=0
            GBE2COST=0
            @@@@@ /etc/snmp/snmpd.conf
            master agentx

            agentuser  snmp
            agentgroup  snmp

            #agentaddress udp:161
            agentaddress unix:/var/agentx/master,udp:161

            rocommunity  public
            rwcommunity  private

            trapcommunity public
            trap2sink 192.0.2.0 public 162
            #authtrapenable 0

            sysservices 3

            sysdescr CLEER 24 Coax Switch
            syscontact https://www.nvtphybridge.com/portfolio-item/nv-clr-024/ Tel:1-888-901-3633 Mon-Fri 8am-6pm ET
            syslocation Location not set
            sysobjectid .1.3.6.1.4.1.54743.1.5
            @@@@@ /etc/syslog-phy.conf
            REMOTE_SYSLOGD_IP=192.0.2.0
            REMOTE_SYSLOGD_PORT=514
            @@@@@ /etc/usercfg
            ***** Vlans
            1,fe+ge0-ge1+ge3-ge4,fe+ge3-ge4
            1001,cpu+ge2,ge2
            ***** Default Vlan
            1
            ***** PVlans
            ge0,1
            ge1,1
            ge2,1001
            ge3,1
            ge4,1
            fe0,1
            fe1,1
            fe2,1
            fe3,1
            fe4,1
            fe5,1
            fe6,1
            fe7,1
            fe8,1
            fe9,1
            fe10,1
            fe11,1
            fe12,1
            fe13,1
            fe14,1
            fe15,1
            fe16,1
            fe17,1
            fe18,1
            fe19,1
            fe20,1
            fe21,1
            fe22,1
            fe23,1
            fe24,1
            fe25,1
            fe26,1
            fe27,1
            fe28,1
            fe29,1
            fe30,1
            fe31,1
            fe32,1
            fe33,1
            fe34,1
            fe35,1
            fe36,1
            fe37,1
            fe38,1
            fe39,1
            fe40,1
            fe41,1
            fe42,1
            fe43,1
            fe44,1
            fe45,1
            fe46,1
            fe47,1
            ***** Port Power
            fe0,powered
            fe1,powered
            fe2,powered
            fe3,powered
            fe4,powered
            fe5,powered
            fe6,powered
            fe7,powered
            fe8,powered
            fe9,powered
            fe10,powered
            fe11,powered
            fe12,powered
            fe13,powered
            fe14,powered
            fe15,powered
            fe16,powered
            fe17,powered
            fe18,powered
            fe19,powered
            fe20,powered
            fe21,powered
            fe22,powered
            fe23,powered
            fe24,no-power
            fe25,no-power
            fe26,no-power
            fe27,no-power
            fe28,no-power
            fe29,no-power
            fe30,no-power
            fe31,no-power
            fe32,no-power
            fe33,no-power
            fe34,no-power
            fe35,no-power
            fe36,no-power
            fe37,no-power
            fe38,no-power
            fe39,no-power
            fe40,no-power
            fe41,no-power
            fe42,no-power
            fe43,no-power
            fe44,no-power
            fe45,no-power
            fe46,no-power
            fe47,no-power
            ***** Port State
            ***** Port Medium
            ge3,copper
            ge4,copper
            ***** Port LED
            3
            ***** Jumbo
            1518
            ***** Admin Pass
            admin:$6$4H8uOnkKOtV1rUiY$LdbqxBSiNda7dqJ0M6ECpRBMTz/6hRlJz4ZdbYIY0B952kCMy/YVJvDKlKynGtPYd8jraX.E6OwMG.t4rXUE91:10926:0:99999:7:::
            ***** Static MAC
            ***** Port Speed
            100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100
            ***** Port Enable
            true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,true
            ***** Port Learn Lock
            000000000000000000000000
            ***** RX Idle Lock
            0,0,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false

            @@@@@ /etc/voltage
            560
            @@@@@ /etc/contact
            http://www.nvtphybridge.com/support-ticket/ Tel:1-888-901-3633 Mon-Fri 4am-7pm EST
            @@@@@ /etc/stimeout
            60
            @@@@@ /etc/port-desc
            1 
            2 
            3 
            4 
            5 
            6 
            7 
            8 
            9 
            10 
            11 
            12 
            13 
            14 
            15 
            16 
            17 
            18 
            19 
            20 
            21 
            22 
            23 
            24 
            @@@@@ /etc/igmp
            enable=0
            timeout=240
            noflood=0
            fastleave=0
            poll=5
            vlan=1
            @@@@@ /etc/linkagg
            enable=0
            @@@@@ /etc/lldpd.conf
            @@@@@ /etc/tacacs
            server1=
            secret1=
            server2=
            secret2=
            server3=
            secret3=
            server4=
            secret4=
            account=off
            protocol=login
            timeout=5

            """;}
    String configLines[] = toString().split("\n");

    public NvtPhybridgeSwitch(String name, Double xPosition, Double yPosition, Color color) {
        super(name, xPosition, yPosition, color);
    }

    public String newConfig(){
        for (String line: configLines) {
            System.out.println(line);
        } return "Tada";
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(getColor());
        gc.fillRect(getxPosition() - 50, getyPosition() - 50, 50 * 2, 25 * 2);
        gc.setFill(Color.WHITE);
        gc.fillText(name,getxPosition()-40,getyPosition()-35);
    }



}
