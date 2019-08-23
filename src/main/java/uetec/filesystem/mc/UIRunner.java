package uetec.filesystem.mc;

import java.util.ArrayList;
import java.util.List;

import uetec.filesystem.printer.*;
import uetec.filesystem.ui.module.*;
import uetec.filesystem.ui.pojo.FileSystemPath;
import uetec.filesystem.server.ctl.*;
import uetec.filesystem.server.enumeration.LogLevel;
import uetec.filesystem.server.enumeration.VCLevel;
import uetec.filesystem.server.pojo.ExtendStores;
import uetec.filesystem.server.pojo.ServerSetting;
import uetec.filesystem.server.util.ConfigureReader;
import uetec.filesystem.server.util.ServerTimeUtil;
import uetec.filesystem.ui.callback.*;

/**
 * 
 * <h2>UI界面模式启动器</h2>
 * <p>
 * 该启动器将以界面模式启动uetec-file-system，请执行静态build()方法开启界面并初始化uetec-file-system服务器引擎。
 * </p>
 * 
 * @author 要么出众，要么出局
 * @version 1.0
 */
public class UIRunner {

	private static UIRunner ui;

	private UIRunner() {
		Printer.init(true);
		final ServerUIModule ui = ServerUIModule.getInsatnce();
		KiftdCtl ctl = new KiftdCtl();// 服务器控制层，用于连接UI与服务器内核
		ServerUIModule.setStartServer(() -> ctl.start());
		ServerUIModule.setOnCloseServer(() -> ctl.stop());
		ServerUIModule.setGetServerTime(() -> ServerTimeUtil.getServerTime());
		ServerUIModule.setGetServerStatus(new GetServerStatus() {

			@Override
			public boolean getServerStatus() {
				// TODO 自动生成的方法存根
				return ctl.started();
			}

			@Override
			public int getPropertiesStatus() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getPropertiesStatus();
			}

			@Override
			public int getPort() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getPort();
			}

			@Override
			public boolean getMustLogin() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().mustLogin();
			}

			@Override
			public LogLevel getLogLevel() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getLogLevel();
			}

			@Override
			public String getFileSystemPath() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getFileSystemPath();
			}

			@Override
			public int getBufferSize() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getBuffSize();
			}

			@Override
			public VCLevel getVCLevel() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getVCLevel();
			}

			@Override
			public List<FileSystemPath> getExtendStores() {
				List<FileSystemPath> fsps = new ArrayList<FileSystemPath>();
				for (ExtendStores es : ConfigureReader.instance().getExtendStores()) {
					FileSystemPath fsp = new FileSystemPath();
					fsp.setIndex(es.getIndex());
					fsp.setPath(es.getPath());
					fsp.setType(FileSystemPath.EXTEND_STORES_NAME);
					fsps.add(fsp);
				}
				return fsps;
			}


			@Override
			public LogLevel getInitLogLevel() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getInitLogLevel();
			}

			@Override
			public VCLevel getInitVCLevel() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getInitVCLevel();
			}

			@Override
			public String getInitFileSystemPath() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getInitFileSystemPath();
			}

			@Override
			public String getInitProt() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getInitPort();
			}

			@Override
			public String getInitBufferSize() {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().getInitBuffSize();
			}
		});
		ServerUIModule.setUpdateSetting(new UpdateSetting() {

			@Override
			public boolean update(ServerSetting s) {
				// TODO 自动生成的方法存根
				return ConfigureReader.instance().doUpdate(s);
			}
		});
		ui.show();
	}

	/**
	 * 
	 * <h2>以UI模式运行uetec-file-system</h2>
	 * <p>
	 * 启动UI模式操作并初始化服务器引擎，该方法将返回本启动器的唯一实例。
	 * </p>
	 * 
	 * @author 要么出众，要么出局
	 * @return uetec.filesystem.mc.UIRunner 本启动器唯一实例
	 */
	public static UIRunner build() {
		if (UIRunner.ui == null) {
			UIRunner.ui = new UIRunner();
		}
		return UIRunner.ui;
	}
}
